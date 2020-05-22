public WebDriver ConfigureFirefox() {  
    System.setProperty("webdriver.firefox.marionette","/Users/wshaikh/Downloads/geckodriver");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
    WebDriver driver = new FirefoxDriver(capabilities);

    return driver;
}

@Before
public void SetupTest() {
    Driver = testHelper.ConfigureFirefox();
    checkPointPage = new CheckPointPage(Driver);

    Driver.get(URL);
}