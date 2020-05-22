@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class PasswordResetControllerTest {

    @Autowired 
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    ...

    @Before  
    public void init() {  
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext).build();
    }
}