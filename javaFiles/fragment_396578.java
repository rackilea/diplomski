@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfig.class)
@WebIntegrationTest // This will start the server on a random port
public class IntegrationTestDemoTest {

    // This will hold the port number the server was started on
    @Value("${local.server.port}")
    int port;

    final RestTemplate template = new RestTemplate();

    @Test
    public void testGetMessage() {
        String message = template.getForObject("http://localhost:" + port + "/", String.class);

        Assert.assertEquals("This is a test message", message);
    }
}