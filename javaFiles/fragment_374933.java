@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private CustomX509AuthenticationFilter customX509AuthenticationFilter;

    @Autowired
    private  AuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.x509().x509AuthenticationFilter(customX509AuthenticationFilter);
    }
}