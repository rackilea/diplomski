@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = YourContext.class)
@WebAppConfiguration
public class MyWebTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void foo() throws Exception {
         mockMvc.perform(get("/status"));
       //and verification
    }

}