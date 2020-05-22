@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class HealthCheckerControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private InstanceRepository instanceRepository;

    @Before
    public void setUp() throws Exception {

        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        this.instanceRepository.deleteAll();
        Instance first = new Instance("10.20.30.40", "ami-xxxxxxxx");
        Instance second = new Instance("10.20.30.41", "ami-xxxxxxxx");
        this.instanceRepository.save(first);
        this.instanceRepository.save(second);

        for (Instance instance : this.instanceRepository.findAll()) {
            System.out.println(instance);
        }
    }

    @Test
    public void testHealthChecker() throws Exception {
        mvc.perform(get("/healthchecker")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].ipaddress", is("10.20.30.40")))
                .andExpect(jsonPath("$[0].ami", is("ami-xxxxxxxx")))
                .andExpect(jsonPath("$[1].ipaddress", is("10.20.30.41")))
                .andExpect(jsonPath("$[1].ami", is("ami-xxxxxxxx")));
    }
}