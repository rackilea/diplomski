public static Set<String> extractJobIds(Map<String, ?> map) {
    Set<String> result = new HashSet<>();
    for(String key : map.keySet()) {
        if(key.startsWith(PREFIX) && key.endsWith(SUFFIX))
            result.add(key.substring(PREFIX.length(), key.length()-SUFFIX.length()));
    }
    return result;
}