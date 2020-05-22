protected void configure(HttpSecurity http) throws Exception {
    http
        .httpBasic()
            .authenticationEntryPoint(samlEntryPoint());
    http
        .csrf()
            .disable();
    http
        .addFilterBefore(metadataGeneratorFilter(), ChannelProcessingFilter.class)
        .addFilterAfter(samlFilter(), BasicAuthenticationFilter.class);
    http        
        .authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/error").permitAll()
        .antMatchers("/saml/**").permitAll()
        .anyRequest().authenticated();
    http
        .logout()
            .logoutSuccessUrl("/");
}