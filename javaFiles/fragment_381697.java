public class SignUPBaseclass extends Testbase {
public RemoteWebDriver driver;

@BeforeTest
public RemoteWebDriver SignUp1() throws Throwable  {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("appium-version", "1.0");
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability("platformVersion", "9.3");
    capabilities.setCapability("deviceName", "iPhone 5S Plus");
    capabilities.setCapability("app", "/Users/sumit/Desktop/Project /FSFosh-1.ipa");
     driver = new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);
    return driver;
}