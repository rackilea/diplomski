List<String> list1 = List.of("abc","abc");

List<String> result = 
    Optional.ofNullable(list1)          // Optional<List<String>>
        .stream()                       // Stream<List<String>>
        .flatMap(List::stream)          // Stream<String>
        .map(e -> e.concat("def"))      // Stream<String>
        .collect(Collectors.toList());  // List<String>