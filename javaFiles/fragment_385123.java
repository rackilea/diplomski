List<String> distinct = 
    listMap.values() // Collection<Map<String,String>>
           .stream() // Stream<Map<String,String>>
           .flatMap(map -> map.keySet().stream()) // Stream<String>
           .distinct() // Stream<String>
           .collect(Collectors.toList()); // List<String>