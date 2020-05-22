WebDriver driver = new FirefoxDriver();
driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
driver.get("http://www.servsafe.com/catalog/starterscategories.aspx");
Selenium selenium = new WebDriverBackedSelenium(driver, driver.getCurrentUrl());
selenium.windowMaximize();
((JavascriptExecutor)driver).executeScript("javascript:LoadCategory('CA');");