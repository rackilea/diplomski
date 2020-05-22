List<String> list2 = List.of("abc","abc");

List<String> result =
    Optional.ofNullable(list2)          // Optional<List<String>>
        .map(List::stream)              // Optional<Stream<String>>
        .orElseGet(Stream::empty);      // Stream<String>
        .map(e-> e.concat("def"))       // Stream<String>
        .collect(Collectors.toList());  // List<String>