static class MyInterfaceProxy implements InvocationHandler {
    private static final Map<String, Method> METHODS = new HashMap<>(16);

    static {
        // Scan each interface method for the specific annotation
        // and save each compatible method
        for (final Method m : IMyInterface.class.getDeclaredMethods()) {
            if (m.getAnnotation(YourAnnotation.class) != null) {
                METHODS.put(m.getName(), m);
            }
        }
    }

    private final IMyInterface toBeProxied;

    private MyInterfaceProxy(final IMyInterface toBeProxied) {
        // Accept the real implementation to be proxied
        this.toBeProxied = toBeProxied;
    }

    @Override
    public Object invoke(
            final Object proxy,
            final Method method,
            final Object[] args) throws InvocationTargetException, IllegalAccessException {
        // A method on MyInterface has been called!
        // Check if we need to call it directly or if we need to
        // execute something else before!
        final Method found = METHODS.get(method.getName());

        if (found != null) {
            // The method exist in our to-be-proxied list
            // Execute something and the call it
            // ... some other things
            System.out.println("Something else");
        }

        // Invoke original method
        return method.invoke(toBeProxied, args);
    }
}