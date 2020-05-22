@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/vaadinServlet/**", "/VAADIN/**", "/PUSH/**",
                    "/UIDL/**", "/login", "/login/**", "/register",
                    "/environment").permitAll()
            .antMatchers("/**").fullyAuthenticated()
                .and()
            .csrf().disable()
            .exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login/"))
                .and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
}