Stream<String> strings = ... ;
Iterator<String> stringsIt = strings.iterator();
if (stringsIt.hasNext()) {
  System.out.printf("header: %s%n", stringsIt.next());
  while (stringsIt.hasNext()) {
    System.out.printf("line: %s%n", stringsIt.next());
  }
}