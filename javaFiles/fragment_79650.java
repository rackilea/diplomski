public void Initiating() throws IOException {
    Properties prop= new Properties();
    InputStream fis = new FileInputStream("D:\\Workspace\\TMS\\selenium\\ZLive\\src\\datadriven.properties");
    prop.load(fis);


    System.out.println("Initiating Browser");

    if (prop.getProperty("browser").equals("firefox"))
    {
        driver=new FirefoxDriver();
    }
    else
    {
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    driver.manage().window().maximize();
    driver.get(prop.getProperty("url"));
    return driver;   //return the driver object.
 }