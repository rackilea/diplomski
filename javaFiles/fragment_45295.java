driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='contentFrame']")));
driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id='RichTextEditor_surface']")));

((JavascriptExecutor) driver).executeScript("document.body.innerHTML = '<br>'");

WebElement bodyOfMail = driver.switchTo().activeElement();

bodyOfMail.sendKeys("Your mail body content here");

//this is for switch back to default window from frame
driver.switchTo().defaultContent();