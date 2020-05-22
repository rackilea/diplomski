public Object invoke(final MethodInvocation methodInvocation) throws Throwable {
    String methodName = methodInvocation.getMethod().getName();

    Object[] arguments = methodInvocation.getArguments();
    if (arguments.length >= 2) {
        if (arguments[0] instanceof String) {
            String content = (String) arguments[0];
            if(content.equalsIgnoreCase("A")) {
                if (methodInvocation instanceof ReflectiveMethodInvocation) {
                    ReflectiveMethodInvocation invocation = (ReflectiveMethodInvocation) methodInvocation;
                    arguments[1] = false;
                    invocation.setArguments(arguments);
                }
            } else {
                if (methodInvocation instanceof ReflectiveMethodInvocation) {
                    ReflectiveMethodInvocation invocation = (ReflectiveMethodInvocation) methodInvocation;
                    arguments[1] = true;
                    invocation.setArguments(arguments);
                }
            }
        }
    }
    return methodInvocation.proceed();
}