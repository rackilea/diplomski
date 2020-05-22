System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addArguments("test-type");
options.addArguments("start-maximized");
options.addArguments("--enable-automation");
options.addArguments("test-type=browser");
options.addArguments("disable-infobars");
WebDriver driver = new ChromeDriver(options);