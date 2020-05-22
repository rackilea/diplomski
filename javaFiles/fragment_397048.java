public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

private AuthenticationManager authenticationManager;
private TokenService tokenService;
private UserModel credentials;

private RefreshTokenService refreshTokenService;
private AuthTokenModelRepository authTokenModelRepository;
private UserModelRepository userModelRepository;

public JWTAuthenticationFilter( String loginUrl, AuthenticationManager authenticationManager,
        TokenService tokenService, RefreshTokenService refreshTokenService,
        AuthTokenModelRepository authTokenModelRepository, UserModelRepository userModelRepository )
{
    super(new AntPathRequestMatcher(loginUrl));

}