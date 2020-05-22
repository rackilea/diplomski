Map<String, List<String>> output =
    map.entrySet()
       .stream()
       .collect(Collectors.toMap(Map.Entry::getKey,
                                 e->e.getValue()
                                     .stream()
                                     .filter(s -> s.length() > 5)
                                     .collect(Collectors.toList())));