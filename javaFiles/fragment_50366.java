enum LogHeaders {

    SESSION_ID("_sid", "SESSION-ID", "SID"),
    CORRELATION_ID("cid", "CORRELATION-ID", "CID");

    final String key;
    final Map<String, String> variations;

    private LogHeaders(final String key, String... variation) {
        this.key = key;
        variations = Arrays.stream(variation).collect(collectingAndThen(
                toMap(x -> x, x -> key),
                Collections::unmodifiableMap
        ));
    }

    // unmodifiable map of every variation to its key
    public final static Map<String, String> variationToKey =
        Arrays.stream(LogHeaders.values())
            .flatMap(lh -> lh.variations.entrySet().stream())
            .collect(collectingAndThen(
                            toMap(Map.Entry<String, String>::getKey, Map.Entry<String, String>::getValue),
                            Collections::unmodifiableMap
            ));  // will throw if 2 keys have the same variation
}