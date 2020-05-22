public class SendMessageToExpertTest extends utility.tested.Test {

    private AndroidDriver<MobileElement> driver; // first device
    private AndroidDriver<MobileElement> driver2; // second device
    // Other members if needed.

    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        driver = SetUpDriver.getMobileDriver("1");
        driver2 = SetUpDriver.getMobileDriver("2");
        // Init other objects if needed.
    }

    @Category(Regression.class)
    @Test
    public void sendMessageToExpertTest() throws Exception {
        // Perform your test.
        // TODO
    }
}