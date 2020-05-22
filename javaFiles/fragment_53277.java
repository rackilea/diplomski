static {
      instantiateDriver();        
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
}

private static void instantiateDriver() {

      //numFork will be passed in the maven command line or eclipse 
      //--- clean install -DnumFork=${surefire.forkNumber}
      int browserType = Integer.parseInt(System.getProperty("numFork"));

      System.out.println("BROWSER TYPE "+browserType);

      if(browserType == 1)
          instantiateChromeDriver();

      else if (browserType == 2)
          instantiateFirefoxDriver();

      else if (browserType == 3) {    
          instantiateIEDriver();
      }       

  }

  private static void instantiateIEDriver() {
      //Implement this
  }

  private static void instantiateFirefoxDriver() {

      REAL_DRIVER = new FirefoxDriver();
      REAL_DRIVER.manage().window().maximize();   
  }

  private static void instantiateChromeDriver() {

      System.setProperty("webdriver.chrome.driver", "location of chromedriver.exe");
      ChromeOptions chop =  new ChromeOptions();
      chop.addArguments("test-type");
      chop.addArguments("start-maximized");
      chop.addArguments("--disable-extensions");

      REAL_DRIVER = new ChromeDriver(chop);
  }