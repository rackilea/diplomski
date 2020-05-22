public final class Providers {
    public static AnnotatedClassProvider newBased(String basePackage) {
        return new AbstractAnnotatedClassProvider() {
            @Override
            public <A extends Annotation> ImmutableMap<Class<?>, A> get(Class<A> annotation) throws IOException {
                return super.find(annotation, basePackage);
            }
        };
    }

    public static AnnotatedClassProvider newSimple() {
        return new AbstractAnnotatedClassProvider() {
            @Override
            public <A extends Annotation> ImmutableMap<Class<?>, A> get(Class<A> annotation) throws IOException {
                return super.find(annotation, null);
            }
        };
    }
}