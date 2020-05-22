@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private JwtAuthenticationProvider authenticationProvider;

    @Autowired
    public WebSecurity(@Qualifier("authLogic") AuthLogic userDetailsImpl) {
        this.authenticationProvider = new JwtAuthenticationProvider(userDetailsImpl);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}