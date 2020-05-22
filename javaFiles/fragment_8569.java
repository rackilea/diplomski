System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
    WebDriver driver=new FirefoxDriver();
    driver.get("http://phptravels.com/demo/");
    String my_text = driver.findElement(By.xpath("html/body/section[2]/div/div/div[1]/div/div/div[2]/div[2]/div/div[3]/div[2]/div")).getText();
    String[] words = my_text.split(" "); 
    String email= words[1];
    String password = words[3];
    System.out.println(my_text);