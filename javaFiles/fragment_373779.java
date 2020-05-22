System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
options.setExperimentalOption("useAutomationExtension", false);
WebDriver driver =  new ChromeDriver(options);
driver.get("https://www.google.com/");