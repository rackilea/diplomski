Map<String, List<String>>
    merged =
        Stream.of(data,data1) // create a Stream<Map<String,String> of all Maps
              .flatMap(map->map.entrySet().stream()) // map all the entries of all the
                                                     // Maps into a 
                                                     // Stream<Map.Entry<String,String>>
              .collect(Collectors.groupingBy(Map.Entry::getKey, // group entries by key
                                             Collectors.mapping(Map.Entry::getValue,
                                                                Collectors.toList())));