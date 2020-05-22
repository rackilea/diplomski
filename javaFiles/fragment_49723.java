ChromeOptions options = new ChromeOptions();
options.addArguments("test-type");
options.addArguments("disable-popup-blocking");
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
WebDriver driver = new ChromeDriver(capabilities);