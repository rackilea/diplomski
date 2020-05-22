public class Mux {

    /**
     * @param targetInterface
     *            the interface to create a proxy for
     * @param instances
     *            the concrete instances to delegate to
     * @return a proxy that'll delegate to all the arguments
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<T> targetInterface, final T... instances) {
        ClassLoader classLoader = targetInterface.getClassLoader();
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method m, Object[] args)
                    throws Throwable {
                for (T instance : instances) {
                    m.invoke(instance, args);
                }
                return null;
            }
        };
        return (T) Proxy.newProxyInstance(classLoader,
                new Class<?>[] { targetInterface }, handler);
    }
}