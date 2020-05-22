static <T> T as(Class<T> clazz, Object obj) {
    if (clazz.isInstance(obj)) {
        return (T) obj;
    }
    return null;
}