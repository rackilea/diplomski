WebDriver driver;

@BeforeTest 
public static void OpenBrowser() {
    FirefoxOptions options = new FirefoxOptions();
    options.setHeadless(true);
    driver = new FirefoxDriver(options);
}