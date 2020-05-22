// simulate mouse movement to the dropdown 
Actions actions = new Actions(driver);
actions.moveToElement(driver.findElement(By.xpath(xpath1))).perform();

// wait for the element to be visible before clicking on it
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.visibilityOfElementLocated(xpath2)).click();