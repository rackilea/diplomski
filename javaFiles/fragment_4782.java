WebDriver driver = new ChromeDriver();
    driver.get("http://www.google.com");
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    System.out.println(driver.getTitle());

    //Robot Class
    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_CONTROL);
    r.keyPress(KeyEvent.VK_T);
    r.keyRelease(KeyEvent.VK_CONTROL);
    r.keyRelease(KeyEvent.VK_T);

    //Switch to new tab
    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("http://www.yahoo.com/");
    System.out.println(driver.getTitle());