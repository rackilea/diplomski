public class TestModule1 {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = TestLogin.getDriver();
    }

    @Test
    void module1Test() {
        //Code to perform the module 1 test
    }

    public static WebDriver getDriver() {
        return driver;
    }

}