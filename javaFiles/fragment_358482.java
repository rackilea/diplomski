private OAuth2ClientContextFilter oAuth2ClientContextFilter;

public OAuth2SsoConfiguration(
    @Qualifier("authorizationHeaderRequestMatcher")RequestMatcher authorizationHeaderRequestMatcher, 
    CorsFilter corsFilter, 
    OAuth2ClientContextFilter oAuth2ClientContextFilter
) {
    this.authorizationHeaderRequestMatcher = authorizationHeaderRequestMatcher;
    this.corsFilter = corsFilter;
    this.oAuth2ClientContextFilter = oAuth2ClientContextFilter;
    .....
}