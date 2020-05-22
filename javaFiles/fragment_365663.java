public static void main(String[] args) {
    Map<NGram, Integer> countMap = new HashMap<>();
    add(countMap, new NGram("Foo"));
    add(countMap, new NGram("Bar"));
    add(countMap, new NGram("Foo", "Bar"));
    add(countMap, new NGram("This", "is", "a", "test"));
    add(countMap, new NGram("Bar"));
    System.out.println(countMap);
}
private static void add(Map<NGram, Integer> countMap, NGram ng) {
    Integer counter = countMap.get(ng);
    countMap.put(ng, (counter != null ? counter + 1 : 1));
}