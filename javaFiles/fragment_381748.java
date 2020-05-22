public static Map<String, String> copyToStringValueMap(
        Map<String, Object> input) {
    Map<String, String> ret = new HashMap<>();
    for (Map.Entry<String, Object> entry : input.entrySet()) {
        ret.put(entry.getKey(), (String) entry.getValue());
    }
    return ret;
}