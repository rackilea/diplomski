WebDriverWait wait = new WebDriverWait(driver, 10);

//Click on read more button to open this dialog
wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Read More"))).click();

//Now wait until this dialog close button visible and clickable then click  
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.close"))).click();