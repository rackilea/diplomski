WebElement elem = driver.findElement(By.cssSelector("div.mainActionPanel > a"));
 WebDriverWait wait= new WebDriverWait(driver, 20);

 wait.until(ExpectedConditions.visibilityOf(elem));

 elem.click();