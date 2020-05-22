List<Integer> input = Arrays.asList(-1, -3, -5, -120, 0, 15, 24, 42, 13, -15, -24, -42, 1, 2, 3);
    List<Integer> filtered = input.stream().filter(x -> x != 0).collect(Collectors.toList());

    int[] indexes = IntStream.range(0, filtered.size() - 2)
            .filter(x -> x == 0 || x == filtered.size() || filtered.get(x) >>> 31 != filtered.get(x + 1) >>> 31)
            .map(x -> x + 1)
            .toArray();

    List<List<Integer>> result = IntStream.range(0, indexes.length - 1)
            .mapToObj(x -> filtered.subList(indexes[x], indexes[x + 1]))
            .collect(Collectors.toList());

    System.out.println(result);