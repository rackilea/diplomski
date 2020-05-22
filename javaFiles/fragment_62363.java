@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests().antMatchers("/v1/crash/consumeCrashBoxxEvent").hasRole("ADMIN").and()
            .httpBasic().authenticationEntryPoint(getBasicAuthEntryPoint()).and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}