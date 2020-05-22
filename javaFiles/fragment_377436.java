DesiredCapabilities capabilities = DesiredCapabilities.chrome();

ChromeOptions options = new ChromeOptions(); 
options.addArguments("--start-maximized"); 

capabilities.setCapability(ChromeOptions.CAPABILITY, options);

driver = new RemoteWebDriver(URL, capabilities);
//driver = new ChromeDriver(capabilities);