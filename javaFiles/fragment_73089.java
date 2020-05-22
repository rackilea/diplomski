WebElement element = driver.findElement(By.cssSelector("selector"));

Actions actions = new Actions(driver);
actions.moveToElement(element).build().perform();

WebDriverWait wait = new WebDriverWait(driver, 15);
wait.until(ExpectedConditions.elementToBeClickable(element)).click();