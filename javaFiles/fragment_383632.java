public static Map<String, List<String>> agg(){
    List<String> list = Arrays.asList("Item A", "Item B", "Item C");
    List<String> servers = Arrays.asList("Server A", "Server B", "Server C", "Server D");
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < list.size(); i++) {
        map.put(list.get(i), new ArrayList<>(servers));
    }
    return map;
}