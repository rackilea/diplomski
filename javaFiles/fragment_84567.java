private static boolean isBuddyOf(
        final Class<? extends Annotation> annotation,
        final Class<?> classToTest) {
    return Stream.of(classToTest.getAnnotations())
            .anyMatch(a -> a.annotationType().isAnnotationPresent(annotation));
}