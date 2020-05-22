public class SomeTest {

    WebDriver driver;

   @Before
   public void setUp() throws Exception {
        ...
        driver = new FirefoxDriver();
        ...
        driver.get(baseURL);
   }

   @Test
   public void test() {
       driver.getTitle(); //just an example
   }

   .... // other methods

}