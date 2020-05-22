public class MyTest {
    @ClassRule
    public static final TestResources res = new TestResources();
    @Test
    public void testFoo() {
        // test logic here
    }
}

public class TestResources extends ExternalResource {
    protected void before() {
        // Setup logic that used to be in @BeforeClass
    }
    protected void after() {
        // Setup logic that used to be in @AfterClass
    }
}