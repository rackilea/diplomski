class MyExtension implements Extension {
    <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
        Class<?> annotatedTypeClass = pat.getAnnotatedType().getJavaClass();
        boolean result = isBuddyOf(Fred.class, annotatedTypeClass);
        [...]
    }