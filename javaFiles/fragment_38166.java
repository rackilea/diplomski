// Find the sum of X and group by name
Map<String, Integer> sumXByName = Stream.of(first, second, third, fourth, fifth)
        .collect(groupingBy(ExampleClass::getName, 
                Collectors.<ExampleClass>summingInt(e -> e.getX())));

// Print the results
sumXByName.entrySet().stream()
    .map(e -> e.getKey() + " -> " + e.getValue())
    .forEach(System.out::println);