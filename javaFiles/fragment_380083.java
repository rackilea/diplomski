//...
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServerCallTest {
   @Autowired
   private IBusiness biz;

   @Autowired
   private RestTemplate restTemplate;

   private ClientHttpRequestFactory originalClientHttpRequestFactory;

   @Before
   public void setUp() {
       originalClientHttpRequestFactory = restTemplate.getRequestFactory();
   }

   @After
   public void tearDown() {
      restTemplate.setRequestFactory(originalClientHttpRequestFactory);
   }

   @Test
   public void fetchAllEntries() throws BookListException {
      MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

       mockServer                
            .andExpect(method(HttpMethod.GET))
            .andExpect(header("Accept", "application/json"))
            .andExpect(requestTo(endsWith("/list/entries/")))
            .andRespond(withSuccess("your-payload-here", MediaType.APPLICATION_JSON));

       MyData data = biz.getData();

       //do your asserts
   }
}