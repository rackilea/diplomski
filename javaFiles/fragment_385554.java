@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controller.class)
public class ControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private Service serviceMock;

   @Test
    public void test() throws Exception {
        mockMvc.perform(get(URL))
        .andExpect(status().isOk());
    }

}