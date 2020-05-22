@Resource
private SessionContext context;

private String getCurrentUsername() {
    return context.getCallerPrincipal().getName();
}