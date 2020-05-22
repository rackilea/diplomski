@RunWith(SpringJUnit4ClassRunner.class)
    @EnableAutoConfiguration
    @SpringBootTest(classes = {BackendApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class MyCookieClientTest {
        @LocalServerPort
        int localPort;

        @Autowired
        RestTemplateBuilder restTemplateBuilder;

        private TestRestTemplate template;

        @PostConstruct
        public void initialize() {
            RestTemplate customTemplate = restTemplateBuilder
                .rootUri("http://localhost:"+localPort)
                ....
                .build();
            this.template = new TestRestTemplate(customTemplate,
                 null, null, //I don't use basic auth, if you do you can set user, pass here
                 HttpClientOption.ENABLE_COOKIES); // I needed cookie support in this particular test, you may not have this need
        }
    }