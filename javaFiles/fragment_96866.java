public class QuickTest extends TestCase
{
    @Test(expected = Exception.class)
    public void test() throws Exception {
        throwsException();
    }
}