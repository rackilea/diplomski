String checkboxXPath =("//input[contains(@type='checkbox',@name='key_IT_CONFIG.ios.restriction.functionality.enable.camera_checkboxVal')]");

WebDriverWait wait = new WebDriverWait(driver,30);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkboxXPath)));

WebElement elementToClick = driver.findElement(By.xpath(checkboxXPath));
elementToClick.click();