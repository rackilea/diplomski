WebElement iframe = driver.findElement(By.tagName("iframe"));
driver.switchTo().frame(iframe);
WebElement tinymce = driver.findElement(By.tagName("body"));
tinymce.clear();
tinymce.sendKeys("Automation Description");

//Now switch back first to default 
driver.switchTo().defaultContent();

 //Now you can go to find next element