public static String extractHttpVerb(Method method) {
    for (Annotation annotation: method.getAnnotations()) {
        if (annotation.annotationType().isAnnotationPresent(HttpMethod.class)) {
            return annotation.annotationType().getSimpleName();
        }
    }
    return null;
}