class Initalizer implements InvocationHandler {
    private A delegate;
    Initializer(A delegate) {
        this.delegate = delegate;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        if (method.isAnnotationPresent(magic.class)) {
            magic annotation = method.getAnnotation(magic.class);
            delegate.init(magic.arg);
        }
        method.invoke(delegate, args);
    }
} 
A realA = ...;
A obj = Proxy.newProxyInstance(A.class.getClassLoader(), new Class[] {A.class}, new Initializer(realA));