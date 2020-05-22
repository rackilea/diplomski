@RunWith(SpringRunner.class)
@Import(OAuth2MockMvcConfig.class)
public class OAuth2ControllerTest {

    @MockBean
    private ResourceServerTokenServices tokenService;

    @Autowired
    protected OAuth2MockMvcHelper api;

    @Autowired
    protected SerializationHelper conv;

    @Before
    public void setUpTokenService() {
        when(tokenService.loadAuthentication(api.VALID_TEST_TOKEN_VALUE))
                .thenAnswer(invocation -> SecurityContextHolder.getContext().getAuthentication());
    }
}