@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestMainController {

    @Autowired
    private MainController mainController;

    @MockBean
    private CarsService carsServiceMock;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void initMocks() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .build();
    }