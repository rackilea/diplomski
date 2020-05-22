public class MyTestCase extends TestCase
    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(MyTestCase.class);
    }
    ...
}