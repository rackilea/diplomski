@Before("execution(public static * business.security.service.LoginManagerHelper.authenticateUser(..)) && args( username, ..)")
public void pointcut1(String username) {
    doSomethingWithUsername(username);
}

@Before("execution(public static * webapp.util.LoginManagerAction.loginJAAS(..)) && args( *, *, username, ..)")
public void pointcut2(String username) {
    doSomethingWithUsername(username);
}

private void doSomethingWithUsername(String username) {
    // inject the username into the MDC
    MDCUtils.setUsername(username);
}