//Select Channel 
Select oSelectChannel = new Select(driver.findElement(By.id("client"))); 
oSelectChannel.selectByVisibleText("Insurance Test Client"); 

WebDriverWait wait5 = new WebDriverWait(driver, 10);
wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("xpath_of_a_Category_item")));

//Select Category 
Select oSelectCategory = new Select(driver.findElement(By.xpath("//*[@id='category']"))); 
oSelectCategory.selectByVisibleText("Product Insurance");