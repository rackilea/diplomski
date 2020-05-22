WebElement yourChkBox  = driver.findElement(By.xpath("//*[@id='agree_to_terms_join']/parent::label"));

WebDriverWait wait = new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.visibilityOf(yourChkBox));

Actions act = new Actions(driver);
act.moveToElement(yourChkBox).click().build().perform();