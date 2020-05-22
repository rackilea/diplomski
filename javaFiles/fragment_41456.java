final Map<String, Set<String>> newMap = new HashMap<>();

for (Map<String, String> map: list) {                        // iterate the List<Map>
    for (Entry<String, String> entry: map.entrySet()) {      // iterate the entries
        final String key = entry.getKey();                   // get the entry's key
        newMap.computeIfAbsent(key, k -> new HashSet<>());   // compute a new pair
        newMap.get(key).add(entry.getValue());               // add a value in any case
    }
}