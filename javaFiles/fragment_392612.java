int minWordLength = 4;
int minPairLength = 8;

Set<String> strings = Stream
   .of(
      "a", "abc", "abcdef", "def", "sun", "sunshine", "shine",
      "bear", "hug", "bearhug", "cur", "curlique", "curl",
      "down", "downstream", "stream"
   )
   .filter(s -> s.length() >= minWordLength)
   .collect(ImmutableSet.toImmutableSet());

strings
   .stream()
   .filter(s -> s.length() >= minPairLength)
   .flatMap(s -> IntStream
      .rangeClosed(minWordLength, s.length() - minWordLength)
      .mapToObj(splitIndex -> ImmutableList.of(
         s.substring(0, splitIndex),
         s.substring(splitIndex)
      ))
      .filter(pair ->
          strings.contains(pair.get(0))
          && strings.contains(pair.get(1))
      )
   )
   .map(pair ->
      pair.get(0) + pair.get(1) + " = " + pair.get(0) + " + " + pair.get(1)
   )
   .forEach(System.out::println);