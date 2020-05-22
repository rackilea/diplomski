//first switch to out side the frame
driver.switchTo().defaultContent();

//now implement WebDriverWait to provide wait
WebDriverWait wait = new WebDriverWait(driver, 100);

//wait until ExpectedConditions is not true
WebElement buttonEl = wait.until(ExpectedConditions.elementToBeClickable(By.id("saveBtnDialog")));

//now you go for the action
buttonEl.click();