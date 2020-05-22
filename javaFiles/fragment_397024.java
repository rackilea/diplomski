public static void main(String[] args){
    System.setProperty("webdriver.chrome.driver", "F:\\Automation\\chromedriver.exe");
            String pathToExtension = "C:\\Users\\USER_DELL_2014_07\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3\\Extensions\\bhlhnicpbhignbdhedgjhgdocnmhomnp\\2.0_0";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("load-extension=" + pathToExtension);
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
          }