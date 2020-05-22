private static final Token EMPTY_TOKEN = null;

OAuthService service = new ServiceBuilder()
                           .provider(FacebookApi.class)
                            .apiKey(apiKey)
                            .apiSecret(apiSecret)
                             .callback("http://www.example.com/oauth_callback/")
                              .build();
 String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);