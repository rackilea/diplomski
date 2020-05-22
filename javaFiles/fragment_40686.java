Arrays.asList(array).stream()
    .collect(Collectors.groupingBy(it -> counter .getAndIncrement() / 3))
    .values()
    .stream()
    .mapToInt(val-> val.stream().mapToInt(Integer::intValue).sum())
    .forEach(System.out::print);