Stream<String> strings = ... ;
Iterator<String> stringsIt = strings.iterator();
if (stringsIt.hasNext()) {
  System.out.printf("header: %s%n", stringsIt.next());
  stringsIt.forEachRemaining(line -> { System.out.printf("line: %s%n", line); });
}