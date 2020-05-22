public static Map<String, List<String>> agg(){
    List<String> list = Arrays.asList("Item A", "Item B", "Item C");
    List<String> servers = Arrays.asList("Server A", "Server B", "Server C", "Server D");

    return list.stream()
            .collect(Collectors.toMap(key -> key, key -> new ArrayList<>(servers)));
}