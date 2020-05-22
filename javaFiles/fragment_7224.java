//Default filter order=3 so this will be executed after WebSecurityConfigurerAdapter 
    public class MicroserviceSecurityConfiguration extends ResourceServerConfigurerAdapter {
       ...
      //Here I am intercepting the same url but the config will look for bearer token only
      @Override
public void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().exceptionHandling()
    .and().headers().frameOptions().disable()
    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    .and().authorizeRequests()
    .antMatchers("/api/**").authenticated();
    }
   }