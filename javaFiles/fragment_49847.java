@Override
public void configure(WebSecurity web) throws Exception {
    // JwtAuthenticationTokenFilter will ignore the below paths
    web.ignoring().antMatchers(
            HttpMethod.POST,
            "/api/auth/**"
    );
    web.ignoring().antMatchers(
            HttpMethod.GET,
            "/",
            "/actuator/**",
            "/beer/**",
            "/comment/**",
            "/signIn",
            "/asset-manifest.json",
            "/favicon.ico",
            "/index.html",
            "/service-worker.js",
            "/static/**",
            "/webjars/**",
            "/*.html",
            "/favicon.ico",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js"
    );
}