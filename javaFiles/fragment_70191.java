stream.collect(Collectors.groupingBy(s -> getAnagramKey(s)))
    .values().stream()
    .filter(l -> l.size() > 1)
    .sorted(Collections.reverseOrder(Comparator.comparingInt(List::size)))
    .limit(10)
    .forEach(System.out::println);