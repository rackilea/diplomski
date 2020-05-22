public static Map<String, List<String>> agg(){
    List<String> list = Arrays.asList("Item A", "Item B", "Item C");
    List<String> servers = Arrays.asList("Server A", "Server B", "Server C", "Server D");

    Function<String, String> keyFunction = key -> key;
    Function<String, List<String>> valueFunction = key -> new ArrayList<>(servers);

    return list.stream()
            .collect(Collectors.toMap(keyFunction, valueFunction));
}