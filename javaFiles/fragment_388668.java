@Override
protected void configure(HttpSecurity http) throws Exception {
    http
       .csrf().disable()                
       .and()
       .httpBasic()
       .and()
       .authorizeRequests()                
       .antMatchers(HttpMethod.GET, "/*").permitAll()
       .antMatchers(HttpMethod.GET, "/add").authenticated()
       .antMatchers(HttpMethod.GET, "/report/*").authenticated()
       .anyRequest().authenticated();                
}