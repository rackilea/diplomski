List<Integer> numbers = Arrays.asList(2, 3, 2, 3, 2, 2, 9);
Map<Integer, Long> map = numbers.stream()
        .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
        .entrySet()
        .stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / 2));

// output
map.forEach((num, count) -> System.out.println(String.format("%d has %d unique pairs", num, count)));
Long total = map.values().stream().reduce((acc, c) -> c + acc).get();
System.out.print(String.format("A total of %d pairs", total));