final Map<String, Set<String>> map = new HashMap<>();

map.put("A", ImmutableSet.of("Dukmerriot", "King", "Pumpkin"));
map.put("B", ImmutableSet.of("Steve"));
map.put("C", ImmutableSet.of("Jib", "Jab", "John", "Julie"));
map.put("D", ImmutableSet.of("Apple", "Amy", "Unicorn", "Charlie", "Raptor"));
map.put("E", new HashSet<String>());

List<String> keys = new ArrayList<>(map.keySet());
Collections.sort(keys, new Comparator<String>() {

    @Override
    public int compare(String o1, String o2) {
        return Integer.valueOf(map.get(o2).size()).compareTo(map.get(o1).size());
    }
});

for (String key : keys) {
    System.out.println(key);
}