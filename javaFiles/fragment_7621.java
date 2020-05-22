public class Init {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BS");
        System.setProperty("webdriver.chrome.driver", "");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AS");
        driver.quit();
    }
}