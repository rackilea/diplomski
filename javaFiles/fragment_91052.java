final List<Person> persons = constructPersons(
        new String[]{"Clair", "Alice", "Bob", "Alice"},
        new String[]{"Clear", "Wonder", "Builder", "Ace"}
);
persons.sort(PersonByFirstNameThenByLastNameComparator.INSTANCE);
System.out.println(persons);