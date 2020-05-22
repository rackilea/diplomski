@Listeners(InvokedMethodListener.class)
public class YourTest {
    @Test
    public void test() {
        Assert.fail("some message");
    }
}