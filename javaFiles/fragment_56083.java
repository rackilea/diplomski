public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
           .authorizeRequests()
              .antMatchers("/login", "/admin").hasRole('ADMIN') // e.g. for pages that need to be authenticated
              .anyRequest().permitAll() // all the others will be accessable by all
              .and()
           .formLogin()
              .loginPage("/login")
              .permitAll()
              .and()
           .logout()
              .permitAll();
        }
}