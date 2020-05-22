Utility.implicitlyWaitForElementPresent(mDriver,By.xpath("//*[@id='1014']/a"));
WebElement lexiconCollapsible = mDriver.findElement(By.xpath("//* [@id='1014']/a"));
assertNotNull(lexiconCollapsible);
ScrollHelper.scrollToElement(mDriver,lexiconCollapsible);
Thread.sleep(1000);
lexiconCollapsible.click();