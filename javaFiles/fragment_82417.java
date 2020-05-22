public class TestBase {

    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    protected String abc;

    @BeforeMethod
    public void setUp(){
        System.out.println("I am in setUp method.");

        //WebDriver instantiation etc.
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-cache");
        webDriver.set(new ChromeDriver(options));
        webDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("I am in tearDown method.");
        //You can clean up after tests.
        //webDriver.get().quit();
        webDriver.get().quit();
    }
}