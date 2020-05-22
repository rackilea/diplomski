public class tests extends BaseTest {
    test_a_Home test = new test_a_Home(this);

    @Test
    public void testHomePage() {
        test.testIfExists();
    }
}