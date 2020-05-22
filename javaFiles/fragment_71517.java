public static <T> T getInstance(Class<T> type, Annotation... qualifiers) {
    Set<Bean<?>> beans = getBeanManager().getBeans(type, qualifiers);
    Bean<?> bean = getBeanManager().resolve(beans);

    if(bean == null){
        throw new UnsatisfiedResolutionException();
    }

    @SuppressWarnings("unchecked")
    T instance = (T) getBeanManager().getReference(bean, type,
            getBeanManager().createCreationalContext(bean));
    return instance;
}

public static BeanManager getBeanManager() {
    return CDI.current().getBeanManager();
}