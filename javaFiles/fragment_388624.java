public class TestLogin {
    public static WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    void loginTest() {
        //Code to perform the login test
    }

    public static WebDriver getDriver() {
        return driver;
    }

}