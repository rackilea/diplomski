Map<String,TreeMap<Integer,String>> outerMap = new HashMap<>();

public void insert(String outerKey, Integer innerKey, String innerValue) {
    outerMap.computeIfAbsent(outerKey, k -> new TreeMap<>())
        .put(innerKey, innerValue);
}

public String pollHighest(String outerKey) {
    return Optional.of(outerKey)
        .map(outerMap::get)
        .map(TreeMap::lastEntry)
        .map(Map.Entry::getValue)
        .orElse(null);
}