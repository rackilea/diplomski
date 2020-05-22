@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
protected static class ActualMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    @Qualifier("aclDaoAuthenticationProvider")
    private AuthenticationProvider aclDaoAuthenticationProvider;

    @Autowired
    @Qualifier("aclAnonymousAuthenticationProvider")
    private AnonymousAuthenticationProvider aclAnonymousAuthenticationProvider;

    @Autowired
    @Qualifier("aclExpressionHandler")
    private MethodSecurityExpressionHandler aclExpressionHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.authenticationProvider(aclDaoAuthenticationProvider);
        auth.authenticationProvider(aclAnonymousAuthenticationProvider);
    }

    @Override
    public MethodSecurityExpressionHandler createExpressionHandler() {
        return aclExpressionHandler;
    }