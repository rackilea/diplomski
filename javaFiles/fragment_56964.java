@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-ws.xml"})
public class SetStatusFromSrsTemplateTest {
    @Autowired
    private WebServiceTemplate wsTemplate;

    @Before
    public void setUp() throws Exception {
        mockServer = MockWebServiceServer.createServer(wsTemplate);
    }

    @Test
    public void testCall() {
        SomeWebServiceRequest sampleRequest = new SomeWebServiceRequest();
        // add properties to the sampleRequest...
        Source expectedPayload = new ResourceSource(new ClassPathResource("exampleRequest.xml"));
        Source expectedResponse = new ResourceSource(new ClassPathResource("exampleResponse.xml"));
        mockServer.expect(payload(expectedPayload)).andRespond(withPayload(expectedResponse));
        instance.callDownStream(sampleRequest);
        mockServer.verify();
    }
}