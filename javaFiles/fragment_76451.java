@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ControllerTest {

    @Autowired
    UserController userCtrl;

    @Autowired
    public UserRepository userDao;

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void loginTest() throws Exception {

        User user1 = new User();
        user1.setEmail("adres@email.com");
        user1.setPassword("12345");
        userDao.save(user1);

        mockMvc.perform(post("/user/login")
                .param("email", "adres@email.com")
                .param("password", "12345"))
                .andExpect(status().isOk());

    }
}