List<Person> people = Arrays.asList(
        new Person("One", 21, 100),
        new Person("Two", 21, 75),
        new Person("Three", 42, 100),
        new Person("Four", 42, 120),
        new Person("Five", 9, 100)
);
Map<Integer, Map<Integer, Person>> map = people.stream()
        // Gather all ages into a Map<Age,List<Person>>
        .collect(Collectors.groupingBy(Person::getAge))
        // Walk that transient Map.
        .entrySet().stream()
        .collect(Collectors.toMap(
                // Key is the age.
                Map.Entry::getKey,
                // Value is a Map<income,person>
                e -> e.getValue()
                // Roll each of the same age into a Map<Income,Person>
                .stream().collect(
                        Collectors.toMap(
                                // Key is income.
                                Person::getIncome,
                                // Value is the Person.
                                Function.identity()
                        ))));