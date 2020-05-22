public class Login {

    private WebDriver driver;

    public void Find_Fields (String path,String login, String password) {
        driver.get(path);
        //(...) rest of this method is unchanged
    }

    public Login(WebDriver driver) {
        this.driver = driver;
    }
}

public class Testing {

    private static WebDriver driver;
    @BeforeClass
    public static void a_setup(){
        driver = new FirefoxDriver();        //initialize the driver
        Login fields = new Login(driver);    //pass the instance of WebDriver to login class
        fields.Find_Fields(LOGIN_PATH, LOGIN, PASSWORD);
    }

    //(...) rest of the class remains unchanged
}