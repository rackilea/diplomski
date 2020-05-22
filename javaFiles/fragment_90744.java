@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MyGlobalMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    @Autowired
    private MethodSecurityExpressionHandler methodExpressionHandler;

    @Autowired
    private AccessDecisionManager methodAccessDecisionManager;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return methodExpressionHandler;
    }

    @Override
    protected AccessDecisionManager accessDecisionManager() {
        return methodAccessDecisionManager;
    }

}