public enum UriStatusMessages {
    URL_VALID(10_000),
    URL_INVALID(-10_001),
    URL_HAS_NOT_QUERY_STRING(-10_002),
    URL_HAS_NOT_VALID_QUERY_STRING(-10_003);

    private final int value;
    private UriStatusMessages(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}