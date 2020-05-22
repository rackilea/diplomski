@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApp.class)
@WebIntegrationTest(randomPort = true)
@OAuth2ContextConfiguration(MyDetails.class)
public class MyControllerIT implements RestTemplateHolder {
    @Value("http://localhost:${local.server.port}")
    @Getter
    String                      host;

    @Getter
    @Setter
    RestOperations              restTemplate    = new TestRestTemplate();

    @Rule
    public OAuth2ContextSetup   context         = OAuth2ContextSetup.standard(this);

    @Test
    public void testHelloOAuth2WithRole() {
        ResponseEntity<String> entity = getRestTemplate().getForEntity(host + "/hello", String.class);
        assertTrue(entity.getStatusCode().is2xxSuccessful());
    }
}

class MyDetails extends ResourceOwnerPasswordResourceDetails {
    public MyDetails(final Object obj) {
        MyControllerIT it = (MyControllerIT) obj;
        setAccessTokenUri(it.getHost() + "/oauth/token");
        setClientId("myclientwith");
        setUsername("user");
        setPassword("password");
    }
}