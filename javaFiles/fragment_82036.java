public <T extends Object> T getOverride(Class<T> cls, MethodHandler handler) {
    ProxyFactory factory = new ProxyFactory();
    factory.setSuperclass(cls);
    factory.setFilter(
            new MethodFilter() {
                @Override
                public boolean isHandled(Method method) {
                    return Modifier.isAbstract(method.getModifiers());
                }
            }
        );

    return (T) factory.create(new Class<?>[0], new Object[0], handler);
}