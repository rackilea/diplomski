// Wait for modal
WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("document-content")));
// Select last child of content div
WebElement element = driver.findElement(By.xpath("//div[@id='document-content']/*[last()]")); 
// Scroll to last child node
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);