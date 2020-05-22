Number[] test = {1.122, 1.12, 1.1, 1.23, 1.5, 4.01, 1};
List<String> converted = Arrays
    .stream(test)
    .map((n) -> 
        String.valueOf(n)
    )
    .sorted()
    .collect(Collectors.toList());
System.out.println(converted);