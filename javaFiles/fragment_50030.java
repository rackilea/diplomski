public static <E extends Enum<E>> E valueOf(E defaultValue, String s) {
    try {
        return Enum.valueOf(defaultValue.getDeclaringClass(), s);
    } catch (Exception e) {
        return defaultValue;
    }
}