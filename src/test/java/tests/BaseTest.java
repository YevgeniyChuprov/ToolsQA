package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeAll
    static public void beforeAll(){
        Configuration.browserSize = "1920x1080";
        open("https://demoqa.com/automation-practice-form");
    }
}
