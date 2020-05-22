@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles(profiles = "test")
public class TransactionsTest {

private MockMvc mockMvc;

@Autowired
private WebApplicationContext context;

@Mock
private Currency currency;

@InjectMocks
private Transactions transactions;

@Before
public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    RestAssuredMockMvc.mockMvc = MockMvcBuilders.standaloneSetup(transactions).build();
}