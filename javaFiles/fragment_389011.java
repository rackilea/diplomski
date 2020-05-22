@Bean
public OAuth2RestOperations restTemplate() {
OAuth2RestTemplate template = new OAuth2RestTemplate(resource(), new 
DefaultOAuth2ClientContext(accessTokenRequest));
AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(new 
AuthorizationCodeAccessTokenProvider()));
provider.setClientTokenServices(clientTokenServices());
return template;
}.