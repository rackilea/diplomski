public class TestModule2 {
    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = TestModule1.getDriver();
    }

    @Test
    void module2Test() {
        //Code to perform the module 2 test
    }

    public static WebDriver getDriver() {
        return driver;
    }

}