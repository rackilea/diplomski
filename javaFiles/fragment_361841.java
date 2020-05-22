System.setProperty("webdriver.gecko.driver", "./Dependencies/geckodriver0.18.0");
    System.setProperty("webdriver.chrome.driver", "./Dependencies/chromedriver");

    Proxy p = new Proxy();
    p.setHttpProxy("103.66.44.19:53281");//replace this with your desired proxy
    p.setSslProxy("103.66.44.19:53281");//from https://free-proxy-list.net/

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(CapabilityType.PROXY,p);

    //For Chrome browser instance
    WebDriver driver = new ChromeDriver(caps);

    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    driver.get("https://www.google.com");
    Thread.sleep(20000);
    driver.quit();

    // For Firefox driver instance
    driver = new FirefoxDriver(caps);

    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    driver.get("https://www.google.com");
    Thread.sleep(20000);
    driver.quit();