public class AbstractHook {
protected static WebDriver driver;

    protected WebDriver getdriver() {
        if (driver == null) {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
            driver = new FirefoxDriver();

        } else if (driver == null) {

            System.setProperty("webdriver.chrome.driver",
                "chromedriver.exe");
            driver = new ChromeDriver();

        } 
        return driver;
    }