driver.navigate().to("https://shopiqa.com/"); 
driver.manage().window().maximize();
new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.envite-iframe")));
JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,500)");
new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#desktop-start>button"))).click();