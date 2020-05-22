System.setProperty("phantomjs.binary.path", "webdriver/phantomjs.exe");
    WebDriver driver = new PhantomJSDriver();

    driver.get("http://google.com");
    Thread.sleep(20000);        
    File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileCopyUtils.copy(file, new File("C:/Users/username/Desktop/screenshot.jpg")); 

    Actions a = new Actions(driver);

    a.moveToElement(driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"))).click().perform();
    a.sendKeys("Hello").perform();