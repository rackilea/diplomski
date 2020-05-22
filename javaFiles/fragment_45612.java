List<List<Integer>> list = Arrays.asList(
    Arrays.asList(1, 2, 3, 4),
    Arrays.asList(5, 6, 7, 8)
);

List<Integer> sumList = IntStream.range(0, list.get(0).size())
                                 .mapToObj(i -> list.stream()
                                                    .mapToInt(l -> l.get(i))
                                                    .sum())
                                 .collect(Collectors.toList());

System.out.println(sumList);