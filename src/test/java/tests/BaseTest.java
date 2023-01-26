package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helper.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import owner.WebDriverConfig;


import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
     static WebDriverConfig driver;

    @BeforeAll
    static public void beforeAll(){
        System.setProperty("env", "local");

        driver = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.baseUrl = driver.getBaseUrl();
        Configuration.browser = driver.getBrowser();
        Configuration.browserVersion = driver.getBrowserVersion();
        Configuration.browserSize = driver.getBrowserSize();
        Configuration.timeout = driver.getTimeout();

        if(driver.isRemote()) {
            Configuration.remote = driver.getRemoteURL();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    @BeforeEach
    public void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments(){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
