public static Throwable getRoot(Throwable t) {
    Throwable result = t;

    while (result.getCause() != null) {
        result = result.getCause();
    }

    return result;
}