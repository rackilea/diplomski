@RunWith(Parameterized.class)
public class ExampleTest{

    private static csvTools csvTools = new csvTools();
    private static WebDriver driver;
    // ...
    @BeforeClass
    public static void openBrowser() throws Exception {
        driver = CreateWebDriver.getDriver("chrome");
        page = new BasePage(driver);
        // ...
    }
    // ...
}