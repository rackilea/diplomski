// the function to identify your key
Function<String[], String> keyFunction = strings -> strings[strings.length - 1];
// the function to identify your values
Function<String[], List<String>> valuesFunction = strings -> Arrays.asList(strings).subList(0, strings.length - 1);
// a collector to add all entries of a collection to a (sorted) TreeSet 
Collector<List<String>, TreeSet<Object>, TreeSet<Object>> listTreeSetCollector = Collector.of(TreeSet::new, TreeSet::addAll, (left, right) -> {
  left.addAll(right);
  return left;
});

Map myMap = Arrays.stream(messages) // or: messages.stream()
  .map(s -> s.split("-"))
  .peek(validator::validate)
  .collect(Collectors.groupingBy(keyFunction,
      Collectors.mapping(valuesFunction, listTreeSetCollector)));