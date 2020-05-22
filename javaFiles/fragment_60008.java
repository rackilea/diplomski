//if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("marionette", true);
WebDriver driver = new MarionetteDriver(capabilities);