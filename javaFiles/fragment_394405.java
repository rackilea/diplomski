// Use injection to get an in-memory reposiroty or client registrations
@Bean
WebClient webClient(ClientRegistrationRepository clientRegistrations) {

    // Provides support for an unauthenticated user such as an application
    ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(
            clientRegistrations, new UnAuthenticatedServerOAuth2AuthorizedClientRepository());

    // Build up a new WebClientCustomizer implementation to inject the oauth filter
    // function into the WebClient.Builder instance
    return new WebClientSecurityCustomizer(oauth);
}