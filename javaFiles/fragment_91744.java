@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { 
        "classpath:/spring/root-test-context.xml"})
public class UserAppTest implements InitializingBean{

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    // other test methods...

    @Override
    public void afterPropertiesSet() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(springSecurityFilterChain)
                .build();
    }
}