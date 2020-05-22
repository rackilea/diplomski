@Bean
    WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 =
                new ServletOAuth2AuthorizedClientExchangeFilterFunction
                        (authorizedClientManager);
        oauth2.setDefaultClientRegistrationId("auth1");
        return WebClient.builder()
                .apply(oauth2.oauth2Configuration())
                .build();
    }