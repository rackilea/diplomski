public class MyTestClass {

    @BeforeClass
    public static void calledBeforeAnyTestIsRun() {
        // Do something
    }

    @Before
    public void calledBeforeEachTest() {
       // Do something
    }

    @Test
    public void testAccountCRUD() throws Exception {
    }
}