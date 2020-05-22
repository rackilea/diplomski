public class BaseClass {

    Webdriver driver;
    @BeforeSuite
    public void setUp() {
        startSeleniumSession();
        // other initialization like reporting,logger and globals required
        loginApplication();
        logoutApplication();
    }

    public void startSeleniumSession(){
        driver=new ChromeDriver()
    }

    // Other generic methods
    public void loginApplication(){

    }

    // Other generic methods
    public void logoutApplication(){

    }

    @AfterSuite
    public void tearDown() {
        driver.close
        logout();
    }
}


public class TestClass1 extends BaseClass{

    @BeforeTest
    public void prerquisiteClass1(){
        // Run before every test in class
    }


    @Test
    public void class1Test1(){
        // functional test 1
    }

    @Test
    public void class1Test2(){
        // functional test 2
    }

    @AfterTest(){
        // take screenshot on failure for class 1 tests
        // this will run for all tests in class
    }



}


public class TestClass2 extends BaseClass{

    @BeforeTest
    public void prerquisiteClass2(){
        // test needs these things
    }


    @Test
    public void class2Test1(){
        // functional test 1
    }

    @Test
    public void class2Test1(){
        // functional test 2
    }

    @AfterTest(){
        // take screenshot on failure for class 2 tests
    }

}