@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfiguration extends
    WebSecurityConfigurerAdapter {


    @Autowired
    public void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user1")
            .password("password1")
            .roles("ADMIN")
            .and()
            .withUser("user2")
            .password("password2")
            .roles("USER");
    }