Set<String> keys = Set.of("id", "name", "lastname");
Map<String,List<Integer>> map = Map.of("id", List.of(1,2,3), "name", List.of(4,5,6));

map.entrySet()
        .stream()
        .allMatch(entry -> keys.contains(entry.getKey()) && entry.getValue() != null);

Map<String,List<Integer>> map1 = Map.of("id", List.of(1,2,3), "not in the keys", List.of(4,5,6));
map1.entrySet()
        .stream()
        .allMatch(entry -> keys.contains(entry.getKey()) && entry.getValue() != null);