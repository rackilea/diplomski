class MyTest {
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        controller = new Controller( /*inject dependencies here*/ );
    }
}