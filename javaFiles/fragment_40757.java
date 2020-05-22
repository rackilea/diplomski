private static String[] merge(String[] tests, String[] expectations) {
    if (tests.length != expectations.length) {
        throw new IllegalArgumentException("input not of same length");
    }
    return IntStream.range(0, tests.length).mapToObj(i -> tests[i] + "," + expectations[i]).toArray(String[]::new);
}