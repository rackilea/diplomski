@Autowired
private Filter springSecurityFilterChain;

@Test
public void testValidUserWithInvalidRoleFails() throws Exception {
    MockMvc mockMvc = standaloneSetup(myController)
        .addFilters(springSecurityFilterChain)
        .setViewResolvers(viewResolver())
        .build();
    ...