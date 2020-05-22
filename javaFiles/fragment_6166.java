List<String> elements = readJson.values()             // Collection<Map<String, List<String>>>
    .stream()                                         // Stream<Map<String, List<String>>>
    .flatMap(value -> value.values().stream())        // Stream<List<String>>
    .flatMap(listOfStrings -> listOfStrings.stream()) // Stream<String>
    .collect(Collectors.toList());                    // List<String>

System.out.println(elements);