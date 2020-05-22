public class SomeTest {
    @Before
    public void before() throws Exception {
        Assume.assumeTrue("someValue".equals(System.getProperty("some.property")));
    }

    // add your @Test
}