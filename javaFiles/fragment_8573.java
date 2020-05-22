...
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyAuthenticationProvider myAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new MyAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
        ...
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(myAuthenticationProvider));
    }
}