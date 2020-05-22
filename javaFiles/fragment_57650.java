@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional    
public class MyIntTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext ctx;  

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post(**Your URL").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        builder.setContent("Your JSON request data");

        // This will invoke POST request to "URL"
        this.mockMvc.perform(builder);

        // If you want to verify your result
       MvcResult result = this.mockMvc.perform(builder).andReturn();

      // Read response. If its custom class then just change return type.
      List responses = getPojoFromMvcResult(result, List.class);
    }

    public static <T> T getPojoFromMvcResult(MvcResult result, Class<T> valueType) throws IOException {
        try {
            MockHttpServletResponse response = result.getResponse();
            String responseJson = response.getContentAsString();
            return convertJsonToObject(responseJson, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertJsonToObject(String content, Class<T> valueType) throws IOException {
        return new ObjectMapper().readValue(content, valueType);
    }
}