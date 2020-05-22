@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private AccessDecisionManager accessDecisionManager;

    @Autowired
    private MethodSecurityExpressionHandler methodSecurityExpressionHandler;

    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return methodSecurityExpressionHandler;
    }

    protected AccessDecisionManager accessDecisionManager() {
        return accessDecisionManager;
    }
}