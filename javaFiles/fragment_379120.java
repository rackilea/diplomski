List<String> longStrings = 
    map.values()
       .stream()
       .flatMap(Collection::stream)
       .filter(s->s.length() > 5)
       .collect(Collectors.toList());