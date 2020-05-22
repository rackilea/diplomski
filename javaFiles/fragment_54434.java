@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("scratch")
public class SampleDataJpaApplicationTests {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testDto() throws Exception {

        BikeDto bikeDto = new BikeDto();
        bikeDto.setId(42L);
        bikeDto.setType("bike");
        bikeDto.setModelYear(2019);
        bikeDto.setFrameType("carbon");

        Gson gson = new Gson();
        String json = gson.toJson(bikeDto);

        this.mvc.perform(post("/testDto").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().json(json));
    }
}