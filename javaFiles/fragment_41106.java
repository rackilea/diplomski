@Override
  protected void configure(HttpSecurity http) throws Exception
  {
      http
        .authorizeRequests()  
            .antMatchers("/login.htm", "/signup.htm").permitAll()
            .antMatchers("/page1.htm", "/page2.htm", "/page3.htm").access("@permission.hasPermission(principal.username,request))
....
}