import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class SecurityMockMvcTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void withUserRequestPostProcessor() {
        mvc
            .perform(get("/admin").with(user("admin").roles("USER","ADMIN")))
            ...
    }

    @WithMockUser(roles="ADMIN")
    @Test
    public void withMockUser() {
        mvc
            .perform(get("/admin"))
            ...
    }

 ...