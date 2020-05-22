Map<String, List<String>> newMap = new HashMap<>();
for (Map.Entry<String, String> entry : masterList.entrySet()) {
    List<String> values = new LinkedList<>();
    if (entry.getKey().startsWith("tag_")) {
        String[] words = entry.getValue().split(",\\s*");
        Collections.addAll(values, words);
     } else {
        values.add(entry.getValue());
     }
     newMap.put(entry.getKey(), values);
}