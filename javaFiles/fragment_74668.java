@Override
public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity             
          .authorizeRequests()
             .antMatchers("/")
                 .permitAll()
             .anyRequest()
                 .authenticated()
             .and()
          .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
          .logout()
             .permitAll()
         ;
 }