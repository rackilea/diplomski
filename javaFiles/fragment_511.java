@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true )
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private GlobalSettingsService globalSettingsService;

    @Configuration
    @Order(1)
    public static class FirstPrefixWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/app1/**")
                .authorizeRequests()
                .antMatchers("/app1/**").permitAll()
                .antMatchers("/app1/login").permitAll()
                .antMatchers("/app1/admin/**")
                .hasAnyRole("ADMIN","USER")
                .and()
                .formLogin().loginProcessingUrl("/app1/login")
                .loginPage("/app1/login").permitAll()
                .defaultSuccessUrl("/app1/admin")
                .failureUrl("/app1/login?error").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/app1/login?logout"))
                .logoutSuccessUrl("/app1/login?logout")
                .permitAll();

        }
    }
    @Configuration
    @Order(2)
    public static class SecondPrefixWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/app2/**")
                .authorizeRequests()
                .antMatchers("/app2/**").permitAll()
                .antMatchers("/app2/login").permitAll()
                .antMatchers("/app2/admin/**")
                .hasAnyRole("ADMIN","USER")
                .and()
                .formLogin().loginProcessingUrl("/app2/login")
                .loginPage("/app2/login").permitAll()
                .defaultSuccessUrl("/app2/admin")
                .failureUrl("/app2/login?error").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/app2/login?logout"))
                .logoutSuccessUrl("/app2/login?logout")
                .permitAll();


        }
    }
    @Configuration
    @Order(3)
    public static class ThirdPrefixWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/app3/**")
                .authorizeRequests()
                .antMatchers("/app3/**").permitAll()
                .antMatchers("/app3/login").permitAll()
                .antMatchers("/app3/admin/**")
                .hasAnyRole("ADMIN","USER")
                .and()
                .formLogin().loginProcessingUrl("/app3/login")
                .loginPage("/app3/login").permitAll()
                .defaultSuccessUrl("/app3/admin")
                .failureUrl("/app3/login?error").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/app3/login?logout"))
                .logoutSuccessUrl("/app3/login?logout")
                .permitAll();


        }
    }

}