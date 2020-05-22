@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
//@ContextConfiguration()
@ActiveProfiles(profiles = {Profiles.WEB_REST})
//@TestPropertySource("/config/rest.yml")
@WebMvcTest(EntityController.class)
@DirtiesContext
public class ServicesControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Controller controller;

    @Test
    public void testAll() throws Exception {
        given(controller.process(null)).willReturn(null);

        mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}