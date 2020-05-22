public class MyTests {

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webApplicationContextSetup(this.wac)
            .addFilters(this.springSecurityFilterChain).build();
    }

    @Test
    public void testLoginPostController() throws Exception {
        Account account = new AccountBuilder("test", "test", "test@gmail.com", Address.FAKE_EMPTY_ADDRESS4TESTS)
                .build();
        this.mockMvc.perform(post("/j_spring_security_check").param("j_username", account.getUsername()).param("j_password", "test"))
                .andDo(print())
                .andExpect(status().isMovedTemporarily())
                .andExpect(view().name("redirect:/public/index.htm"));
    }

}