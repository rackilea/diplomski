public void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/login**").hasRole("user")
            .anyRequest().authenticated()
    .and()
            .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint());
}

private AuthenticationEntryPoint authenticationEntryPoint() {
    return new AuthenticationEntryPoint() {
        // You can use a lambda here
        @Override
        public void commence(HttpServletRequest aRequest, HttpServletResponse aResponse,
               AuthenticationException aAuthException) throws IOException, ServletException {
            aResponse.sendRedirect(MY_AS_URL + "?redirect_uri=localhost:9001/home");
        }
    };
}