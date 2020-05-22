// to make sure you are in the default content
// this is not necessary in the most of the cases
driver.switchTo().defaultContent(); // use only if you are in a frame already

driver.switchto().frame("framename or id");
//driver.switchto().frame(driver.findElement(By.xpath("frame locator")));
//driver.switchto().frame(zero-based frameindex);

// now in the frame
WebDriverWait driverWait = new WebDriverWait(driver, 10000);
WebElement dynamicElement = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("file_upload")));
System.out.println(dynamicElement.getText());

// if you want to get out of all frames back to default content
driver.switchTo().defaultContent();