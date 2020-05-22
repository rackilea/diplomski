Map<Integer,String> map1 = map(1,"a1", 2,"b1", 3,"c1");
Map<Integer,String> map2 = map(1,"a2", 2,"b2", 3,"c2");
Map<Integer,String> map3 = map(1,"a3", 2,"b3", 3,"c3");

Map<Integer, LinkedHashSet<String>> m = Stream.of(map1, map2, map3)
    .flatMap( map -> map.entrySet().stream() )
    .collect( Collectors.groupingBy(Map.Entry::getKey,
        LinkedHashMap::new,
        Collectors.mapping(Map.Entry::getValue,
            Collectors.toCollection(LinkedHashSet::new))));
LinkedHashSet<LinkedHashSet<String>> result=new LinkedHashSet<>(m.values());
// [[a1, a2, a3], [b1, b2, b3], [c1, c2, c3]]
System.out.println(result);