Optional<Set<Integer>> result = powerSet.stream().parallel()
    .filter(e -> isClique(e))
    .collect(
       Collectors.maxBy(
           (set1, set2) -> Integer.compare(set1.size(), set2.size())
       )
    );