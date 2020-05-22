@Override
public void configure( HttpSecurity http ) throws Exception
{
    http.addFilterBefore(new LoginPageFilter(), DefaultLoginPageGeneratingFilter.class);
    // @formatter:off
    http
            .cors()
            .and()
            .exceptionHandling()
            .accessDeniedHandler( accessDeniedHandler() )
            .authenticationEntryPoint( new RestAuthenticationEntryPoint() )
            .and()
            .authorizeRequests()
            .antMatchers( "/login" ).permitAll()
            // ...
    // @formatter:on
}