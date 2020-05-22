@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingResourceTest {

    @LocalServerPort
    private int port;

    private URI uri;

    @Before
    public void setUp() throws Exception {
        this.uri = new URI("http://localhost:" + port);
    }

    @Test
    public void testGreeting() {

        Client client = ClientBuilder.newClient();
        Response response = client.target(uri).path("api").path("greetings")
                                  .request(MediaType.TEXT_PLAIN).get();

        String entity = response.readEntity(String.class);
        assertEquals("Hello, World!", entity);
    }
}