@BeforeTest
public void startBrowser() {
    System.setProperty("webdriver.gecko.driver", driverPath);
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);
    FirefoxOptions options = new FirefoxOptions();
    options.merge(capabilities);
    driver = new FirefoxDriver(options);