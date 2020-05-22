Actions actions = new Actions(driver);                        
actions.moveToElement(driver.findElement(By.xpath("//*[@id='dateOfBirth']")));
actions.click();
actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE);
Thread.sleep(3000);     
actions.sendKeys("07-12-2018");
actions.sendKeys(Keys.TAB);
actions.build().perform();