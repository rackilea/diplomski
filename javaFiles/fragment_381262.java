final Map<String, List<String>> mapOfLists = new HashMap<>();
for (Map<String, String> map : list) {
    for (Entry<String, String> entry : map.entrySet()) {
        if (!mapOfLists.containsKey(entry.getKey())) {
            mapOfLists.put(entry.getKey(), new ArrayList<>());
        }
        mapOfLists.get(entry.getKey()).add(entry.getValue());
    }
}