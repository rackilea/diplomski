static Map<String, String> flatten(Map<String, Object> map, String prefix) {
    prefix = prefix.isEmpty() ? prefix : prefix + ".";
    Map<String, String> res = new HashMap<>();
    for (Map.Entry<String, Object> entry : map.entrySet()) {
        if (entry.getValue() instanceof Map) {
            res.putAll(flatten((Map) entry.getValue(), prefix + entry.getKey()));
        } else {
            res.put(prefix + entry.getKey(), entry.getValue().toString());
        }
    }
    return res;
}