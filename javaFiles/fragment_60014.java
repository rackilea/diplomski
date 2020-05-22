DesiredCapabilities capabilities = DesiredCapabilities.firefox();

// Tell the Java bindings to use Marionette.
// This will not be necessary in the future,
// when Selenium will auto-detect what remote end
// it is talking to.
capabilities.setCapability("marionette", true);

WebDriver driver = new RemoteWebDriver(capabilities);