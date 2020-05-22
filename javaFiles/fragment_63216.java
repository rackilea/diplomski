@Configuration
@Order(2)
public class StatelessConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider).authenticationProvider(secondaryAuthProvider) ;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
           .antMatcher("/api/*").authorizeRequests()
                .antMatchers("/api/**").authenticated().and().httpBasic().realmName("MY_TEST_REALM").
  authenticationEntryPoint(getBasicAuthEntryPoint());
}

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

}