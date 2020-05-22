Stream<List<Integer>> integerListStream = Stream.of(
    Arrays.asList(1, 2), 
    Arrays.asList(3, 4), 
    Arrays.asList(5)
);

Stream<Integer> integerStream = integerListStream .flatMap(Collection::stream);
integerStream.forEach(System.out::println);