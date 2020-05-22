WebDriverWait wait = new WebDriverWait(driver, 10);

wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.cke_wysiwyg_frame.cke_reset")));

WebElement body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
body.sendKeys("Test String");

//Now after entering text into texteditor switch back to default content 
driver.switchTo().defaultContent();