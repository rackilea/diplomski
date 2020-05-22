@Override
public EvaluationContext createEvaluationContext(Authentication auth, MethodInvocation mi) {
    MethodSecurityEvaluationContext ctx = new MethodSecurityEvaluationContext(auth, mi, parameterNameDiscoverer);
    MethodSecurityExpressionRoot root = new MyMethodSecurityExpressionRoot(auth);
    root.setTrustResolver(trustResolver);
    root.setPermissionEvaluator(permissionEvaluator);
    root.setRoleHierarchy(roleHierarchy);
    ctx.setRootObject(root);

    return ctx;
}