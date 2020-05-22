@Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .defaultRequest(get("/"))
                .addFilters(springSecurityFilterChain)
                .apply(springSecurity())
                .build();
    }