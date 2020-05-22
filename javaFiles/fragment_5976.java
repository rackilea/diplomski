@Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void createServer() throws Exception {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void test() {
        String xml = loadFromFile("productsResponse.xml");
        mockServer.expect(MockRestRequestMatchers.anything()).andRespond(MockRestResponseCreators.withSuccess(xml, MediaType.APPLICATION_XML));
    }