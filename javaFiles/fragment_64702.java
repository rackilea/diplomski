@Autowired
FilterChainProxy springSecurityFilterChain;

@Test
public void testOk() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders
        .webAppContextSetup(context)
        .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
        //.setCustomArgumentResolvers(new AuthenticationPrincipalArgumentResolver()) // if you dont have that bean then try with this line and delete above line.
        .build();

    mockMvc.perform(get("/api/auth")
        .with(httpBasic("u", "p")))
        .andExpect(status().isOk());
}