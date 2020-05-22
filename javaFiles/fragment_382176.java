@RunWith(Suite.class)
@SuiteClasses({FooTest.class, BarTest.class})
public class MySuite {
    @ClassRule
    public static TestResources res = TestResources.getTestResources();
    @BeforeClass
    public static void suiteSetup() {
        System.out.println("Suite setup");
    }
    @AfterClass
    public static void suiteTeardown() {
        System.out.println("Suite teardown");
    }
}
public class FooTest {
    @ClassRule
    public static TestResources res = TestResources.getTestResources();

    @Test
    public void testFoo() {
        System.out.println("testFoo");
    }
}
public class BarTest {
    @ClassRule
    public static TestResources res = TestResources.getTestResources();

    @Test
    public void testBar() {
        System.out.println("testBar");
    }
}