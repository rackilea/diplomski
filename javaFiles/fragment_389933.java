@RunWith(Parameterized.class)

public class MyTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"resource1.txt", 0000}, {"resource2.txt", 9999}
        });
    }

    public final URL url;
    public final int expected;

    public MyTest(String resource, int expected) {
        this.url=URL url = this.getClass().getResource("/"+resource)
        this.expected = expected;
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testReadResource() throws Exception {
        // more code here, based on URL and expected
    }

}