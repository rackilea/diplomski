/**
   * Creates a pair list with collectingAndThen, toList(), and PairList::new
   */
  @Test
  public void example() {
    List<List<Integer>> intPairs = Stream.of(1, 2, 3, 4, 5, 6)
        .collect(toPairList());
    System.out.println(intPairs); // [[1, 2], [2, 3], [3, 4]]

    List<List<String>> stringPairs = Stream.of("a", "b", "c", "d")
        .collect(toPairList());
    System.out.println(stringPairs); // [[a, b], [b, c]]
  }