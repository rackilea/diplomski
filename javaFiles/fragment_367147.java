@EnableWebMvc
@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter
{
    private final Environment env;
    private final UserDetailsService myUserDetailsService;

    @Autowired
    public MySecurityConfigurer(Environment env, UserDetailsService myUserDetailsService)
    {
        Assert.notNull(env, "die Umgebungseinstellungen sind NULL");
        this.env = env;
        Assert.notNull(myUserDetailsService, "der myUserDetailsService ist NULL");
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        String urlPattern = env.getProperty("my.springSecurityPattern");
        String realmName = env.getProperty("my.springSecurityRealm");
        String reloadPairingUrl = env.getProperty("my.reloadPairingUrl");

        HttpSecurity securityAdapter = httpSecurity.httpBasic().realmName(realmName)
                .and().userDetailsService(myUserDetailsService)
                .authorizeRequests()
                .antMatchers(reloadPairingUrl).permitAll()
                .antMatchers(urlPattern).authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
    }

}