private static Map<String, Role> cache = new HashMap<>();
static {
    for (Role value : values()) {
        cache.put(value.role, value);
    }
}

public static Role fromString(String string) {
    Role role = cache.get(string);
    if (role == null) {
        throw new IllegalArgumentException("Invalid role: " + string);
    }
    return role;
}