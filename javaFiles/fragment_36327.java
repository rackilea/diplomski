public static long total(List<? extends Number> list) {
    long sum = 0;
    for (Number n : list) {
        if (!(n instanceof Byte || n instanceof Short || n instanceof Integer || n instanceof Long)) {
            throw new IllegalArgumentException();
        }
        sum += n.longValue();
    }
    return sum;
}