WebDriverWait wait = new WebDriverWait(driver,10);

//For first dialog box
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']"))).click();

//Now same as for second dialog box
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.msgButton[id*='msgBox'][id*='FirstButton']"))).click();