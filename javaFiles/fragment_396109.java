Map<String, Integer> map1 = new HashMap<>();
Map<String, Integer> map2 = new HashMap<>();
map1.put("A", 1);
map1.put("B", 2);
map2.put("A", 3);
map2.put("C", 4);
// code above here
result.entrySet().forEach(System.out::println);