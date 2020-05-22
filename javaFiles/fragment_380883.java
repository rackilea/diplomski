public static <T> T nullGuard(Supplier<T> supplier) {
    try {
        return supplier.get();
    } catch (@SuppressWarnings("unused") NullPointerException ignored) {
        return null;
    }
}