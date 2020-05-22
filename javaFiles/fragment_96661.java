@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MyACLConfig {

    //...
    @Bean
    public MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler securityExpressionHandler = new DefaultMethodSecurityExpressionHandler();
        securityExpressionHandler.setPermissionEvaluator(new AclPermissionEvaluator(aclService()));
        securityExpressionHandler.setPermissionCacheOptimizer(new AclPermissionCacheOptimizer(aclService()));
        return securityExpressionHandler;
    }

}