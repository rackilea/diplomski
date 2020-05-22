private final Map<Class<? extends Annotation>, ImmutableMap> cache;

public <A extends Annotation> ImmutableMap<Class<?>, A> get(Class<A> annotation) {
    @SuppressWarnings("unchecked")
    ImmutableMap<Class<?>, A> cached = cache.get(annotation);
    ...
}