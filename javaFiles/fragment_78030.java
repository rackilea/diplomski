class YourInvocationHandler implements InvocationHandler {
    private final NotYourClass target;

    public YourInvocationHandler(NotYourClass target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
                // Here you must look to the methods that are the ones that you want.
                return method..invoke(target, args);
        } catch (Exception e) {
            // Retry?
            method.invoke(target, args);
        }
    }
}