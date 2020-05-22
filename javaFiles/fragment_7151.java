Arrays.stream(given)
    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream()
    .sorted(Map.Entry.<Integer, Long>comparingByValue()
        .thenComparing(Map.Entry.comparingByKey()))
    .flatMap(e -> LongStream.range(0, e.getValue()).mapToObj(l -> e.getKey()))
    .forEach(System.out::println);