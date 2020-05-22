Actions act = new Actions(driver);

//For first dialog box
WebElement firstDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']")));
act.moveToElement(firstDialog).click().perform();

//Now same as for second dialog box
WebElement secondDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']")));
act.moveToElement(secondDialog).click().perform();