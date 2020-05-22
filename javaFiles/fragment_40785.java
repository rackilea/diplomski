WebElement editorFrame = driver.findElement(By.id("scayt_8"));

driver.switchTo().frame(editorFrame);

WebElement body = driver.findElement(By.tagName("body"));

body.clear(); 
body.sendKeys("some text");