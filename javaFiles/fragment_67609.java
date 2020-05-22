@Override
protected void configure(HttpSecurity http) throws Exception {    

  http
     .authorizeRequests() // require authorization
     .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // for the CORS preflight check
     .antMatchers("/login", "/api/open/**", "/resources/**").permitAll()  // the open API endpoints and resources
     .antMatchers("/logout", "/api/secured/**").authenticated(); // lock down these endpoints

  ...additional configurations...
}