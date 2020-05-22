public class AppTest extends ExcelReader {

    public WebDriver driver;
    TestBase TB = new TestBase();

    @BeforeTest
    void browserlaunch() throws InterruptedException, IOException

    {
        driver = TB.initialize();
    }