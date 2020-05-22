int minWordLength = 4;

Set<String> strings = Stream
   .of(
      "a", "abc", "abcdef", "def", "sun", "sunshine", "shine",
      "bear", "hug", "bearhug", "cur", "curlique", "curl",
      "down", "downs", "downer", "downregulate", "downstream", "stream")
   .filter(s -> s.length() >= minWordLength)
   .collect(ImmutableSet.toImmutableSet());

ImmutableList<String> orderedList = strings
   .stream()
   .sorted()
   .collect(ImmutableList.toImmutableList());
List<String> candidates = new ArrayList<>();
List<Map.Entry<String, String>> pairs = new ArrayList<>();

for (String currentString : orderedList) {
   List<String> nextCandidates = new ArrayList<>();
   nextCandidates.add(currentString);
   for (String candidate : candidates) {
      if (currentString.startsWith(candidate)) {
         nextCandidates.add(candidate);
         String remainder = currentString.substring(candidate.length());
         if (remainder.length() >= minWordLength && strings.contains(remainder)) {
            pairs.add(new AbstractMap.SimpleEntry<>(candidate, remainder));
         }
      }
   }
   candidates = nextCandidates;
}
pairs.forEach(System.out::println);