public static <T> T getAnnotation(Class<T> cls, Annotation... annotations) {
    if (annotations == null) {
        return null;
    }
    for (Annotation annotation : annotations) {
        if (cls.isAssignableFrom(annotation.getClass())) {
            return (T)annotation;
        }
    }
    return null;
}