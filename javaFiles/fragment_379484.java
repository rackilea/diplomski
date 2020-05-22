@Component
public class OAuthHelper {

    @Autowired
    AuthorizationServerTokenServices tokenservice;

    public RequestPostProcessor addBearerToken(final String username, String... authorities)
    {
        return mockRequest -> {
            OAuth2Request oauth2Request = new OAuth2Request( null, "client-id",
                        null, true, null, null, null, null, null );
            Authentication userauth = new TestingAuthenticationToken( username, null, authorities);
            OAuth2Authentication oauth2auth = new OAuth2Authentication(oauth2Request, userauth);
            OAuth2AccessToken token = tokenservice.createAccessToken(oauth2auth);

            mockRequest.addHeader("Authorization", "Bearer " + token.getValue());
            return mockRequest;
        };
    }
}