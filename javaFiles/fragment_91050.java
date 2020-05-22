final List<Person> persons = constructPersons(
        new String[]{"Clair", "Alice", "Bob", "Alice"},
        new String[]{"Clear", "Wonder", "Builder", "Ace"}
);
Collections.sort(persons);
System.out.println(persons);