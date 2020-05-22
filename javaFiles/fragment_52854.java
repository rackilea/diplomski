@RunWith(Suite.class)
@Suite.SuiteClasses({ MyTests.class, OtherTest.class })
public class AllTests {
    // empty
}


public class MyTests {  // no extends here
    @BeforeClass
    public static void setUpOnce() throws InterruptedException {
        ...
    @Test
    ...