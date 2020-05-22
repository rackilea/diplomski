driver.get("http://www.google.com/");
   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

   //Open new tab
   JavascriptExecutor jse = (JavascriptExecutor)driver;
   jse.executeScript("window.open()");

   //Switch to new tab 
   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
   driver.switchTo().window(tabs.get(1));
   driver.get("http://www.yahoo.com/");