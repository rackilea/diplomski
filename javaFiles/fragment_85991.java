public class BaseTestCase extends TestCase {

    @Before
    public void setUp() throws Exception {
         //Do something.
     }

    @After
    public void tearDown() throws Exception {
        //Do something.
    }

    protected boolean isElementPresent() {
         //Do something.
         return true;   
    }
    ....

}