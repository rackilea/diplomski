//For first dialog box
WebElement firstDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']")));
((JavascriptExecutor)driver).executeScript("arguments[0].click()",firstDialog);

//Now same as for second dialog box
WebElement secondDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']")));
((JavascriptExecutor)driver).executeScript("arguments[0].click()",secondDialog);