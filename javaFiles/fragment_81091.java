public class setupMethods 
{

    static WebDriver driver;

    public static void setup(String browser) throws Exception
    {
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("firefox"))
        {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", "U:\\path\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        //Check if parameter passed as 'chrome'
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "U:\\selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        //Check if parameter passed as 'Edge'
        if(browser.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver","U:\\path\\IEDriverServer.exe");
            InternetExplorerDriver driver;
            driver = new InternetExplorerDriver();
        }

        else
        {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}