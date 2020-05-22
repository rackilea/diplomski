public class FooFactory implements ApplicationContextAware {

    private Map<Class<?>, Foo<?>> beans = new HashMap<Class<?>, Foo<?>>();

    @SuppressWarnings("unchecked")
    public <T> Foo<T> createFoo(Class<T> c) {
        return (Foo<T>) beans.get(c);
    }

    @SuppressWarnings("unchecked")
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {

        Collection<Foo> candidates = ctx.getBeansOfType(Foo.class).values();
        for (Foo candidate: candidates) {
            Type superclass = candidate.getClass().getGenericSuperclass();
            if (superclass instanceof ParameterizedType) {
                ParameterizedType t = (ParameterizedType) superclass;
                Class<?> p = (Class<?>) t.getActualTypeArguments()[0];
                beans.put(p, candidate);
            }
        }
    }
}