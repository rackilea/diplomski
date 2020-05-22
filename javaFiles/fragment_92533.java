WebDriver seleniumDriver = new FirefoxDriver();
 try {
 String domainString = "http://yourURL";
 String baseUrl = domainString;
 seleniumDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
 seleniumDriver.get(baseUrl + "/Login.aspx/");
 seleniumDriver.findElement(By.id("username")).clear();
 seleniumDriver.findElement(By.id("username")).sendKeys("username");
 seleniumDriver.findElement(By.id("password")).clear();
 seleniumDriver.findElement(By.id("password")).sendKeys("password");
 seleniumDriver.findElement(By.cssSelector("input.primary.btn")).click();
 String ASPNET_SessionId = seleniumDriver.manage().getCookieNamed("ASP.NET_SessionId").toString();
 System.out.println(ASPNET_SessionId);
 }
 finally {
 seleniumDriver.close();
 }