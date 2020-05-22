public static <T> List<T> nullToEmpty(List<T> list) {
    if (list != null) {
        return list;
    }

    return Collections.emptyList();
}