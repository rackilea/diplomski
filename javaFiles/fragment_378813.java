@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AppUserDAO appUserDAO;

    private String accessTokenUri = "http://localhost:8080/oauth/token";
    private String clientId = "clientid";
    private String clientSecret = "clientsecret";

    public AccessTokenProvider userAccessTokenProvider() {
        ResourceOwnerPasswordAccessTokenProvider accessTokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
        return accessTokenProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        List<String> scopes = new ArrayList<String>();
        scopes.add("read");

        final ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();

        resource.setUsername(username);
        resource.setPassword(password);
        resource.setAccessTokenUri(accessTokenUri);
        resource.setClientId(clientId);
        resource.setClientSecret(clientSecret);
        resource.setGrantType("password");
        resource.setScope(scopes);

        // Generate an access token
        final OAuth2RestTemplate template = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        template.setAccessTokenProvider(userAccessTokenProvider());

        OAuth2AccessToken accessToken = null;

        try {
            accessToken = template.getAccessToken();
            System.out.println("Grabbed access token from " + accessTokenUri);
        }
        catch (OAuth2AccessDeniedException e) {
            if (e.getCause() instanceof ResourceAccessException) {
                final String errorMessage = String.format(
                        "While authenticating user '%s': " + "Unable to access accessTokenUri '%s'.", username,
                        accessTokenUri);
                throw new AuthenticationServiceException(errorMessage, e);
            }
            throw new BadCredentialsException(String.format("Access denied for user '%s'.", username), e);
        }
        catch (OAuth2Exception e) {
            throw new AuthenticationServiceException(
                    String.format("Unable to perform OAuth authentication for user '%s'.", username), e);
        }

        // Determine roles for user
        List<GrantedAuthority> grantList = ...

        // Create custom user for the principal
        User user = .....

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null /*dont store password*/, grantList);

        return token;
    }

    @Override
    public  boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}