class Example {
    private final Map<String, Object> m = new HashMap<>();

    void put(String k, Object v) {
        m.put(k, v);
    }

    <T> T get(String k, Class<T> c) {
        Object v = m.get(k);
        return c.isInstance(v) ? c.cast(v) : null;
    }
}

example.put("k", "v");
// returns "v"
String s = example.get("k", String.class);
// returns null
Double d = example.get("k", Double.class);