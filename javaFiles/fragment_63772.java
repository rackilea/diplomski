/**
 * @param instances
 *            the arguments
 * @return a proxy that'll delegate to all the arguments
 */
@SuppressWarnings("unchecked")
public static <T> T create(final T... instances) {

    // Inspect common interfaces
    final Set<Class<?>> commonInterfaces = new HashSet<Class<?>>();
    commonInterfaces.addAll(Arrays.asList(instances[0].getClass()
            .getInterfaces()));

    // Or skip instances[0]
    for (final T instance : instances) {
        commonInterfaces.retainAll(Arrays.asList(instance.getClass()
                .getInterfaces()));
    }

    // Or use ClassLoader.getSystemClassLoader();
    final ClassLoader classLoader = instances[0].getClass().getClassLoader();

    // magic
    final InvocationHandler handler = new InvocationHandler() {
        @Override
        public Object invoke(final Object proxy, final Method m, final Object[] args)
                throws Throwable {
            for (final T instance : instances) {
                m.invoke(instance, args);
            }
            return null;
        }
    };

    final Class<?>[] targetInterfaces = commonInterfaces
            .toArray(new Class<?>[commonInterfaces.size()]);
    return (T) Proxy.newProxyInstance(classLoader, targetInterfaces,
            handler);
}