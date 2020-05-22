List<Person> list = Arrays.asList(
  new Person("John", "Smith"),
  new Person("Anna", "Martinez"),
  new Person("Paul", "Watson ")
);

String joinedFirstNames = list.stream()
  .map(Person::getFirstName)
  .collect(Collectors.joining(", ")); // "John, Anna, Paul"