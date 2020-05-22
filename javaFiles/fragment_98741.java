public static final Map<String, String> KEY_PROTOCOLS;

static {
    Map<String, String> map = new HashMap<String, String>();
    map.put("f", "ftp");
    // ...
    KEY_PROTOCOLS = Collections.unmodifiableMap(map);
}