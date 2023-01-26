package owner;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface WebDriverConfig extends Config {

    @Key("baseURL")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("timeout")
    Long getTimeout();

    @Key("remoteUrl")
    String getRemoteURL();

    @Key("isRemote")
    boolean isRemote();

}
