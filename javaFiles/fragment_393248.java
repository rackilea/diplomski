@RunWith(MockitoJUnitRunner.class)
public class CardApiTest {

    private MockMvc mockMvc;

    @InjectMocks
    private CardManagementController cm;

    @Mock
    private ICardService cardService;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(cm).build();

        // Instantiate cardListRequest and cardListResponse here
        when(cardService.listCards(cardListRequest)).thenReturn(cardListResponse);
    }

    @Test
    public void testList() throws Exception{
        this.mockMvc.perform(get("/v1/card/list?"));
    }
}