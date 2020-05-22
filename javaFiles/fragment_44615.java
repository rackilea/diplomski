public static void removeKey(Map<String, Object> levels, String ... keys) {
    if (levels == null
            || (levels != null && levels.size() == 0)) {
        return;
    }

    for (String k : keys) {
        levels.remove(k);
    }

    for (String key : levels.keySet()) {
        if (levels.get(key) instanceof Map) {
            removeKey((Map<String, Object>) levels.get(key), keys);
        } 
    }
}