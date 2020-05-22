Actions actions = new Actions(driver);
actions.moveToElement(driver.findElement(By.xpath("//*[@id='dateOfBirth']")));
actions.click();
actions.build().perform();
WebElement input = driver.findElement(By.xpath("//*[@id='dateOfBirth']"));
input.clear();
input.sendKeys("07-12-2018");
input.sendKeys(Keys.TAB);