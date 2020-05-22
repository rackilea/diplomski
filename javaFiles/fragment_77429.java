@Override
public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/unprotected/sample/find/**").permitAll()
            .antMatchers("/unprotected/another/register").permitAll()
            .anyRequest().authenticated().and()
            .csrf().disable();
}