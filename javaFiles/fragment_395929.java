// wait at least 10 seconds until element will be visible on tha page
new WebDriverWait(driver, 10).wait(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[@class='headertable']//table//tbody//td[@class='headertext' and @align='left']"))));
String AccName = driver.findElement(By.xpath("//td[@class='headertable']//table//tbody//td[@class='headertext' and @align='left']")).getText().trim();
System.out.println(AccName);

//switch back to default content
driver.switchTo().defaultContent();