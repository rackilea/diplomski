boolean canBeSatisfied(Iterable<Pair<enum, Integer>> conditions) {
  int maxLower = Integer.MAX_VALUE;
  int minUpper = Integer.MIN_VALUE;
  for (Pair<enum, Integer> condition : conditions) {
    maxLower = Math.max(maxLower, getLowerBound(condition));
    minUpper = Math.min(minUpper, getUpperBound(condition));
  }
  return maxLower <= minUpper;
}