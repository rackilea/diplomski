private static String[] merge(String[] tests, String[] expectations) {
    if (tests.length != expectations.length) {
        throw new IllegalArgumentException("input not of same length");
    }
    String[] result = new String[tests.length];
    for (int i = 0; i < tests.length; i++) {
        result[i] = tests[i] + "," + expectations[i]);
    }
    return result;
}