@Autowired
private PermissionEvaluator permissionEvaluator;

@Bean
public DefaultMethodSecurityExpressionHandler expressionHandler() {
    DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
    handler.setPermissionEvaluator(permissionEvaluator);
    return handler;
}