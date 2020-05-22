@Configuration
 @EnableWebSecurity
 public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class SoapApiConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/soap/**")
                .csrf().disable()
                .httpBasic();
        }
    }


    @Configuration
    public static class WebApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

        protected void configure(HttpSecurity http) throws Exception {
            http        
                .formLogin()
                    .loginProcessingUrl("/authentication")
                    .usernameParameter("j_username")
                    .passwordParameter("j_password").permitAll()
                    .and()
                .csrf().disable()

        }
     }
}