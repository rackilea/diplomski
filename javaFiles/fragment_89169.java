Map<Long, Map<String, Double>> map = new HashMap<>();
Map<String, Double> map1 = new HashMap<>();
Map<String, Double> map2 = new HashMap<>();

map1.put("1key1", 1.0);
map1.put("1key2", 2.0);
map1.put("1key3", 3.0);

map2.put("2key1", 4.0);
map2.put("2key2", 5.0);
map2.put("2key3", 6.0);

map.merge(222L, map1, (m1, m2) -> {m1.putAll(m2);return m1;});
map.merge(222L, map2, (m1, m2) -> {m1.putAll(m2);return m1;});
System.out.println(map);