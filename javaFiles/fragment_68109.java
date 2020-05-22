class Example {
    private final Map<String, Object> m = new HashMap<>();

    void put(String k, Object v) {
        m.put(k, v);
    }

    Object getExplicit(String k) {
        return m.get(k);
    }

    @SuppressWarnings("unchecked")
    <T> T getImplicit(String k) {
        return (T) m.get(k);
    }
}