private MockMvc mockMvc

@Autowired
private MyController controller;

@Before
public void setUp() throws Exception {
  this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
}

@Test
public void testMethod() {
   MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/yoururl")).
    andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
}