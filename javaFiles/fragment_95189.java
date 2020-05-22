public static <T> Predicate<T> filter(Class<T> clazz, String fieldName, Object fieldValue) {
    // 1
    return (T instance) -> {
        try {
            final Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            return fieldValue.equals(field.get(instance));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // 2
        }
        return false;
    };
}