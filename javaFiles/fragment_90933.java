private static class SimpleInvocationHandler implements InvocationHandler {
    private Object invokee;

    public SimpleInvocationHandler(Object invokee) {
        this.invokee = invokee;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        method = invokee.getClass().getMethod(method.getName(), method.getParameterTypes());
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        try {
            return method.invoke(invokee, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}

public static <T> T generateProxy(Object realObject, Class... interfaces) {
    return (T) Proxy.newProxyInstance(realObject.getClass().getClassLoader(), interfaces, new SimpleInvocationHandler(realObject));
}