driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

driver.switchTo().frame("iframeResult");
WebElement element = driver.findElement(By.tagName("select"));
Select select = new Select(element);
select.selectByIndex(1);