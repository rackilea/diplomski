// ...

    Map<String, Set<String>> myMap = new HashMap<String, Set<String>>();
    addValue("myValue", "myKey", myMap);

// ...


private void addValue(String value, String key, Map<String, Set<String>> map) {
    Set<String> set = map.get(key);
    if (set == null) {
        set = new HashSet<String>();
        map.put(key, set);
    }
    set.add(value);
}