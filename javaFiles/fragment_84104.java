public static final Map<String, String> CAPITALS;
static {
    Map<String, String> map = new HashMap<>();
    map.put("USA", "Washington, DC");
    map.put("England", "London");
    // ...
    CAPITALS = Collections.unmodifiableMap(map);
}