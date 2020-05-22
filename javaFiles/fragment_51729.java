// call the Chrome driver as below first 
System.setProperty("webdriver.chrome.driver", "D:\\eclipseProject\\##\\src\\com\\##\\chromedriver_win32\\chromedriver.exe");
// path to chrome exe that you have downloaded form given url (below)
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("http://www.seleniumhq.com"); // link to your web-table web page