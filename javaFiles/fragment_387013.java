WebDriverWait wait = new WebDriverWait(driver, 5);
WebElement alertMessageElement = wait
   .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".top.alert.danger.fired")));
Actions actions = new Actions(driver);
actions.moveToElement(alertMessageElement).perform();
String alertMessage = alertMessageElement.getText();

alertMessageElement.findElement(By.cssSelector("button.close")).click();