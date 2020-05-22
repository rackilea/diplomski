@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration
@Import(SecurityConfig.class)
public class LoginFeatureStepDefinition {
    private String username;
    private String password;
    private HtmlPage page;

    @Autowired
    private WebClient webDriver;