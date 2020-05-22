public abstract class AbstractAnnotatedClassProvider implements AnnotatedClassProvider {
    private final Map<Class<? extends Annotation>, ImmutableMap> cache;

    public AbstractAnnotatedClassProvider() {
        this.cache = Maps.newHashMap();
    }

    protected final <A extends Annotation> ImmutableMap<Class<?>, A> find(Class<A> annotation, @Nullable String basePackage) throws IOException {
        @SuppressWarnings("unchecked")
        ImmutableMap<Class<?>, A> cached = cache.get(annotation);

        if (cached != null)
            return cached;

        ClassPath classPath = ClassPath.from(Thread.currentThread().getContextClassLoader());

        ImmutableSet<ClassPath.ClassInfo> set = basePackage == null
                ? classPath.getAllClasses()
                : classPath.getTopLevelClasses(basePackage);

        cached = set.stream()
                .filter(x -> x.load().getAnnotation(annotation) != null)
                .collect(Collectors.collectingAndThen(Collectors
                        .toMap(ClassPath.ClassInfo::load, x -> x.load().getAnnotation(annotation)), ImmutableMap::copyOf));
        this.cache.put(annotation, cached);
        return (cached);
    }
}