@Bean
    public AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource() {

        return new AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>() {

            @Override
            public WebAuthenticationDetails buildDetails(
                HttpServletRequest request) {
                return new CustomAuthenticationDetails(request);
            }

        };
    }

    @Bean
    public AuthenticationProvider customAuthenticationProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String serviceUrl;
                serviceUrl = ((CustomAuthenticationDetails) authentication.getDetails()).getURI();
                if (serviceUrl.equals(env.getRequiredProperty(CAS_URL_CALLBACK_MOBILE))) {
                    return mobileCasAuthenticationProvider().authenticate(authentication);
                } else {
                    return webCasAuthenticationProvider().authenticate(authentication);
                }

            }

            public boolean supports(final Class<?> authentication) {
                return (UsernamePasswordAuthenticationToken.class
                    .isAssignableFrom(authentication))
                    || (CasAuthenticationToken.class.isAssignableFrom(authentication))
                    || (CasAssertionAuthenticationToken.class
                    .isAssignableFrom(authentication));
            }
        };
    }