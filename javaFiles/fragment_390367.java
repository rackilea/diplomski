String jarPath = SeleniumTest.class.getProtectionDomain().
            getCodeSource().getLocation().getPath();
    File file = new File(jarPath);
    String selHome = file.getParentFile().getParent();
    System.setProperty("webdriver.chrome.driver", 
    selHome+"/web_driver/"+"chromedriver.exe");

   WebDriver driver = new ChromeDriver();