System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver-v0.8.0-win32/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("marionette", true);
WebDriver driver = new FirefoxDriver(capabilities);