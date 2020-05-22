public <T> T createProxy(final Class<? extends T> classToMock, final T mock) {
    final MethodInterceptor interceptor = (object, method, args, proxy) -> {
        synchronized (mock) {
            try {
                return method.invoke(mock, args);
            } catch (final InvocationTargetException e) {
                if (e.getCause() != null) {
                    throw e.getCause();
                }
                throw e;
            }
        }
    };

    final Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(classToMock);
    final Set<Class<?>> interfaces = new LinkedHashSet<>();
    if (classToMock.isInterface()) {
        interfaces.add(classToMock);
    }
    interfaces.addAll(Arrays.asList(classToMock.getInterfaces()));
    interfaces.add(CaptureControl.class);
    enhancer.setInterfaces(interfaces.toArray(new Class[interfaces.size()]));
    enhancer.setCallbackType(interceptor.getClass());

    final Class<?> proxyClass = enhancer.createClass();
    Enhancer.registerStaticCallbacks(proxyClass, new Callback[] { interceptor });
    return (T) ObjenesisHelper.newInstance(proxyClass);
}