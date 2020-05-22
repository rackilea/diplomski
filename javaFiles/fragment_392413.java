Map<String, Integer[]> map = new HashMap<>();
 map.put("Name1", new Integer[]{2,5});
 map.put("Name2", new Integer[]{1,4});
 map.put("Name3", new Integer[]{3});


 Map<String, Integer[]> sorted = map
                             .entrySet().stream()
                             .sorted(Comparator.comparing(ent -> ent.getValue()[0]))
                             .collect(Collectors.toMap(Map.Entry::getKey, 
                                                      Map.Entry::getValue,
                                                      (a, b) -> b,                                                        
                                                     LinkedHashMap::new));

 sorted.forEach((k,v) -> System.out.println("{ " + k + " " + Arrays.toString(v) + " }"));