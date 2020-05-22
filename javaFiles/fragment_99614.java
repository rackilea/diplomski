public class Drivers {
    private static boolean initialized = false;
    private static WebDriver driver;

    @Before
    public void initialize(){
        if (!initialized){
            initialized = true;
            driver = new FirefoxDriver();
            driver.get("http://myurl.url");
        }
    }
    public static WebDriver getDriver(){
        return driver;
    }   
}