final List<Person> persons = constructPersons(
        new String[]{"Clair", "Alice", "Bob", "Alice"},
        new String[]{"Clear", "Wonder", "Builder", "Ace"}
);
persons.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName));
System.out.println(persons);