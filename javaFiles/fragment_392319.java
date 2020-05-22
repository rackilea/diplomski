System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
WebDriver driver = new FirefoxDriver();
driver.get("https://www.flipkart.com/search?q=mobile%20phones&otracker=start&as-show=on&as=offFlipkart ecommerce website");
new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='W-gt5y']")));
driver.findElement(By.xpath("//span[@class='W-gt5y']//ancestor::span")).getText();
System.out.println(driver.findElement(By.xpath("//span[@class='W-gt5y']//ancestor::span")).getText());