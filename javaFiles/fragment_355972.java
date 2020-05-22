public class Config extends Verification{

public static WebDriver driver;

public SoftwarePage softwarepage;
public LoginPage loginpage;

@BeforeSuite
public void setUp(){
    driver = DriverFactory.getDriverInstance();
}

@AfterSuite
public void tearDown(){

    if (driver != null) {
        driver.quit();
    }
}