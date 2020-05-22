public static boolean hasSuperAnnotation(Method method, Class<? extends Annotation> check) {
    for (Annotation annotation: method.getAnnotations()) {
        if (annotation.annotationType().isAnnotationPresent(check)) {
            return true;
        }
    }
    return false;
}

[...]
boolean hasHttpMethod = hasSuperAnnotation(method, HttpMethod.class);