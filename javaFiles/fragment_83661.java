System.setProperty("webdriver.gecko.driver", "C:\Users\MI SERVICE\Downloads\geckodriver.exe");
FirefoxOptions capa = new FirefoxOptions();
capa.setCapability("marionette", true);
WebDriver driver = new FirefoxDriver(capa);
driver.navigate().to("https://www.gmail.com");
driver.quit();