public Map < Integer, Double > parallelDiceRolls() { 
  double fraction = 1.0 / N; 
  return IntStream.range( 0, N) .parallel()
    .mapToObj( twoDiceThrows())
    .collect( groupingBy( side -> side, summingDouble( n -> fraction)));
}