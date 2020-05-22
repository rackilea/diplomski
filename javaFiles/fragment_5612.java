NavigableMap<Integer,List<String>> countToWordsMap = new TreeMap<>();
for (Map.Entry<String,Integer> entry : wordToCountMap.entrySet()) {
    Integer count = entry.getValue();
    List<String> list = countToWordsMap.computeIfAbsent(count, new ArrayList<String>());
    list.add(entry.getKey());
    countToWordsMap.put(count, list);
}