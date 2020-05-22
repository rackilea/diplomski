WebDriverWait webDriverWait = new WebDriverWait(driver, 5); // Wait up to five seconds. 
wait.until(ExpectedConditions.visibilityOfElementLocated(
    By.xpath(".//*[@id='header2']/nav/div/ul/li/a"))).click();

// Or perhaps:
//webDriverWait.until(ExpectedConditions.elementToBeClickable(
//    By.xpath("//xpath"))).click();