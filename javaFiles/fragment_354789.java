//@WebMvcTest(ClientController.class)
@RunWith(SpringRunner.class)
public class ClientControllerTest {

    private MockMvc mockMvc;
    @Mock
    ClientService clientService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(
                new ClientController(clientService)
        ).build();
}