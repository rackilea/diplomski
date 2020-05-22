@Before
public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/view/");
    viewResolver.setSuffix(".jsp");

    mockMvc = MockMvcBuilders.standaloneSetup(new LoginController())
            .setViewResolvers(viewResolver)
            .build();
}