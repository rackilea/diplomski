public class NestedTest extends CamelSpringTestSupport {

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("route.xml");
    }

    @Override
    public void setUp() throws Exception {
        deleteDirectory("target/inbound");
        super.setUp();
    }

    @Test
    public void nested() throws InterruptedException {
        getMockEndpoint("mock:end").expectedMessageCount(1);

        template.sendBodyAndHeader("file://target/inbound", 
                "hello camel", 
                Exchange.FILE_NAME, 
                "filename.in"
        );

        assertMockEndpointsSatisfied();
    }
}