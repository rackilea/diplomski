@Test
public class InboundApiControllerIT extends TestNGCitrusTestRunner {

    @Autowired
    private HttpClient httpClient;

    @CitrusTest
    public void okTest() {

        http(action -> action.client(httpClient)
                .send()
                .post("/inbound")
                .payload("{" +
                        "\"userName\": \"Bruce.Wayne\"," +
                        "\"operation\": \"call-a-pizza\"" +
                        "}"));

        http(action -> action.client(httpClient)
                .receive()
                .response(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .payload("{" +
                        "\"success\": true" +
                        "}"));
    }
}