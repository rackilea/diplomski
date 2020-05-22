@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .addFilterBefore(oauthAwareUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        // here come ant rules
        .and()
        .formLogin()
        .and()
            .exceptionHandling().accessDeniedHandler(oauthAwareAccessDeniedHandler());
}