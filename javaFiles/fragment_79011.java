final Hello hello = new Hello() {
    public void hi() {
        System.out.println("Hello World");
    }
};
ProxyFactory factory = new ProxyFactory();
factory.setSuperclass(Hello.class);
MethodHandler handler = (self, m, proceed, args) -> {
    // This allows to proxy even non accessible methods, it could not be
    // needed depending on your context
    if (!m.isAccessible())
        m.setAccessible(true);
    return m.invoke(hello, args);
};
Hello proxy = (Hello)factory.create(new Class<?>[0], new Object[0], handler);
proxy.hi();