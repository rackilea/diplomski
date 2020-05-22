@Resource(name = "accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Bean
    @Qualifier("facebookClientContext")
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public DefaultOAuth2ClientContext facebookClientContext() {
        return new DefaultOAuth2ClientContext(accessTokenRequest);
    }

    @Bean
    public OAuth2RestTemplate facebookRestTemplate(
            @Qualifier("facebookClientContext") OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(facebook(), clientContext);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(
                Arrays.asList(MediaType.APPLICATION_JSON, MediaType.valueOf("text/javascript")));
        template.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList(converter));
        return template;
    }

    @Bean
    public OAuth2RestTemplate sparklrRestTemplate(
            @Qualifier("oauth2ClientContext") OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(sparklr(), clientContext);
    }

    @Bean
    public OAuth2RestTemplate sparklrRedirectRestTemplate(
            @Qualifier("oauth2ClientContext") OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(sparklrRedirect(), clientContext);
    }