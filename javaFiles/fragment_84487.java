@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
    auth
      .jdbcAuthentication()
          .dataSource(dataSource)
          .usersByUsernameQuery(getUserQuery())
          .authoritiesByUsernameQuery(getAuthoritiesQuery())
          .passwordEncoder(shaPasswordEncoder);
}

@Bean 
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
     return super.authenticationManagerBean();
}