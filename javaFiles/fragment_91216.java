// Create a SortedSet of the reversed entry set, with a custom comparator for sorting
SortedSet<Map.Entry<Integer, String>> sortedSet = new TreeSet<Map.Entry<Integer, String>>(
        new Comparator<Map.Entry<Integer, String>>() {
    public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
        // sort by key, then by value --> in descending order
        int keyCompareResult = -o1.getKey().compareTo(o2.getKey()); // negate --> descending
        int valueCompareResult = o1.getValue().compareTo(o2.getValue());
        return keyCompareResult == 0 ? valueCompareResult : -keyCompareResult;
    }
});

// Add all entries of the map to the sorted set
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    Map.Entry<Integer, String> reversedEntry = new AbstractMap.SimpleEntry<Integer, String>(entry.getValue(), entry.getKey());
    sortedSet.add(reversedEntry);
}

// Convert the 10 first elements to the resulting list
int N = 10;
List<String> result = new ArrayList<String>(N);
Iterator<Map.Entry<Integer,String>> iterator = sortedSet.iterator();
while (iterator.hasNext() && result.size() < N) {
    Map.Entry<Integer, String> entry = iterator.next();
    result.add(entry.getValue());
}