List<Integer> list = IntStream.range(1, (int) val + 1)
    .filter(
        i -> Integer.toString(i).chars().distinct().count() == Integer.toString(i).length()
    )
    .boxed()
    .collect(Collectors.toList());