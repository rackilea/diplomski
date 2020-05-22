static class Person {
  private final String name;
  Person(String name) { this.name = name; }
  String name() { return name; }
}

public static void main(String[] args) {
  List<String> result = entriesToBeans(Arrays.asList(new Person("John"), new Person("Fred")),
                                       Person.class, Person::name);
  System.out.println("result = " + result);
}

public static <T, O> List<O> entriesToBeans(List<?> entries,
        Class<T> entryClass, Function<T, O> converter) {
  return entries.stream()
          .filter(entryClass::isInstance)
          .map(entryClass::cast)
          .map(converter)
          .collect(Collectors.toList());
}