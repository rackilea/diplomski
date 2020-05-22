@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        // all the config
        .and()
            .exceptionHandling().accessDeniedHandler(oauthAwareAccessDeniedHandler());
}