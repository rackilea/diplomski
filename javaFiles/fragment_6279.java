int[] sortPartially(int[] inputArray, int limit) {
    Map<Integer, Long> maxValues = IntStream.of(inputArray)
                                            .boxed()
                                            .sorted(Comparator.reverseOrder())
                                            .limit(limit)
                                            .collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));

    IntStream head = maxValues.entrySet()
                              .stream()
                              .flatMapToInt(e -> IntStream.iterate(e.getKey(), i -> i)
                                                          .limit(e.getValue().intValue()));

    IntStream tail = IntStream.of(inputArray)
                              .filter(x -> {
        Long remainingDuplication = maxValues.computeIfPresent(x, (y, count) -> count - 1);
        return remainingDuplication == null || remainingDuplication < 0;
    });

    return IntStream.concat(head, tail).toArray();
}