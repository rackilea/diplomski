Map<Integer, String> map = new LinkedHashMap<>();
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");
map.put(4, "Four");

Map<Integer, String> copy = new LinkedHashMap<>(map);
map.keySet().retainAll(Collections.singleton(3));
map.putAll(copy);

System.out.println(map);