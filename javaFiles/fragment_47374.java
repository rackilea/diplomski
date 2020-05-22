@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyApp.class)
@WebAppConfiguration
public class MyControllerTest {
    @Autowired
    private WebApplicationContext   webapp;

    private MockMvc                 mvc;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(webapp)
                .apply(springSecurity())
                .alwaysDo(print())
                .build();
    }

    @Autowired
    private OAuthHelper helper;

    @Test
    public void testHelloWithRole() throws Exception {
        RequestPostProcessor bearerToken = helper.bearerToken("myclientwith");
        mvc.perform(get("/hello").with(bearerToken)).andExpect(status().isOk());
    }

    @Test
    public void testHelloWithoutRole() throws Exception {
        RequestPostProcessor bearerToken = helper.bearerToken("myclientwithout");
        mvc.perform(get("/hello").with(bearerToken)).andExpect(status().isForbidden());
    }
}