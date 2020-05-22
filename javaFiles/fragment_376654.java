list
    .stream()
    .filter(s -> s.startsWith("x"))
    .map(String::toUpperCase)
    .sorted()
    .forEach(System.out::println);