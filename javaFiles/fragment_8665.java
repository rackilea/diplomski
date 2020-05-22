@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    ... // web stuff here

    @Override
    public configure(AuthenticationManagerBuilder builder) {
        auth.jdbcAuthentication().dataSource(dataSource).withUser("dave")
            .password("secret").roles("USER");
    }

}