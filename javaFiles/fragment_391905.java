@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebTestConfig.class})
@WebAppConfiguration
public class WebTestConfigAware {

  @Autowired
  private WebApplicationContext context;

  protected MockMvc mockMvc;

  @Autowired
  private FilterChainProxy springSecurityFilterChain;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    DeviceResolverRequestFilter deviceResolverRequestFilter = new DeviceResolverRequestFilter();

    mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .addFilters(this.springSecurityFilterChain, deviceResolverRequestFilter).build();
  }

}