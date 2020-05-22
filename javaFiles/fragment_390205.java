public class MyControllerTest {
  @InjectMocks
  private MyController tested;
  // add @Mock annotated members for all dependencies used by the controller here
  private MockMvc mvc;

  // add your tests here using mvc.perform()
  @Test
  public void getHealthReturnsStatusAsJson() throws Exception {
    mvc.perform(get("/health"))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.status", is("OK")));
  }

  @Before
  public void createControllerWithMocks() {
    MockitoAnnotations.initMocks(this);
    MockMvcBuilders.standaloneSetup(controller).build()
  }
}