// switch to iframe, use locator of your choice, "#editMe_ifr" here as an example
WebElement editorFrame = driver.findElement(By.cssSelector("#editMe_ifr"));
driver.switchTo().frame(editorFrame);

WebElement body = driver.findElement(By.TagName("body")); // then you find the body
body.sendKeys(Keys.CONTROL + "a"); // send 'ctrl+a' to select all
body.SendKeys("Some text");