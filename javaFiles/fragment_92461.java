Map<String,Integer> map2 = 
    map1.values()
       .stream()
       .flatMap(m -> m.entrySet().stream()) // create a Stream of all the entries 
                                            // of all the inner Maps
       .collect(Collectors.groupingBy(Map.Entry::getKey,
                                      Collectors.summingInt(Map.Entry::getValue)));