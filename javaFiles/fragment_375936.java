@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Configuration
    @Order(1)
    public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/app1/**/*.*")
                    .permitAll()
                    .antMatchers("/register.html")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    // log in
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login?error=loginError")
                    .defaultSuccessUrl("/postLogin")
                            // logout
                    .and().logout().logoutUrl("/**/logout")
                    .logoutSuccessUrl("/login").deleteCookies("JSESSIONID").and()
                    .csrf()
                    .disable();
        }
    }

    @Configuration
    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/app2/*.*")
                    .hasRole("USER")
                            // log in
                    .and()
                    .formLogin()
                    .loginPage("/login2")
                    .failureUrl("/login2?error=loginError")
                    .defaultSuccessUrl("/postLogin")
                            // logout
                    .and().logout().logoutUrl("/**/logout")
                    .logoutSuccessUrl("/login2").deleteCookies("JSESSIONID").and()
                    .csrf()
                    .disable();
        }
    }
}