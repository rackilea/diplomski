List<Dog> dogs; // populate
Map<String, Integer> counts = new HashMap<>();
for (Dog dog : dogs) {
    Integer count = counts.get(dog.getName());
    counts.put(dog.getName(), count == null ? 1 : count + 1);
}

List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return Integer.compare(o2.getValue(), o1.getValue()); // Note reverse order
    }
});
String leastCommonName = entries.get(0).getKey();
int leastCommonFrequency = entries.get(0).getValue();