Select select = new Select(driver.findElement(By.id("type")));
select.selectByVisibleText("account");  
//OR
//select .selectByIndex(1);  
//OR  
//select .selectByValue("1");