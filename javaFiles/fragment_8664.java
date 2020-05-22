@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    ... // web stuff here

    @Autowired
    public initialize(AuthenticationManagerBuilder builder, DataSource dataSource) {
        auth.jdbcAuthentication().dataSource(dataSource).withUser("dave")
            .password("secret").roles("USER");
    }

}