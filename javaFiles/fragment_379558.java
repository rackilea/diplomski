@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class ReverserRouteTest {    
    @MockBean
    public ReverserService mockReverserService;

    @Autowired
    @Qualifier("specificSerializers")
    public Module jacksonModule;

    @Autowired
    public WebTestClient client;

    @Test
    public void testSerializerBeanIsPresent() {
        assertNotNull(jacksonModule);
    }

    @Test
    public void testRouteAcceptsCall() {
        given(mockReverserService.reverse(anyString())).willReturn(new ReverserResult("foo", "bar"));

        client.get().uri("/reverse/FooBar").exchange().expectStatus().isOk();
    }

    @Test
    public void testRouteReturnsMockedResult() {
        given(mockReverserService.reverse(anyString())).willReturn(new ReverserResult("foo", "bar"));

        client.get().uri("/reverse/somethingcompletelydifferent")
                .exchange()
                .expectBody().json("{\"result\":\"foo|bar\"}");
    }
}