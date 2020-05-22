@Before
 public void setup() throws IOException {
     MockitoAnnotations.initMocks(this);
     mockMvc = MockMvcBuilders.standaloneSetup(controller).setHandlerExceptionResolvers(new ExceptionHandlerExceptionResolver()).build();
 }

 @Test
 public void test() throws Exception {
     mockMvc.perform(get("/verifyCert.controller").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isForbidden());
 }