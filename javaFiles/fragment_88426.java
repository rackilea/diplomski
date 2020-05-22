LinkedHashmap<String, Set<String>> intersectionMap = new LinkedHashmap<>();
if (map.keySet() != null) {
    String[] keys = map.keySet().toArray(new String[map.keySet().size()]);
    for (int i = 0; i < keys.length - 1; i++) {
        String key1 = keys[i];
        String key2 = keys[i + 1];
        TreeSet<String> interSection = intersection(map.get(key1), map.get(key2));
        intersectionMap.put(key1 + "∩" + key2, interSection);
    }
}