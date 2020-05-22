Map<Integer, Person> personMap = 
    persons.stream().collect(Collectors.toMap(Person::getId, Function.identity());

List<PersonWithMetadata> result = 
    metadata.stream()
            .map(m -> new PersonWithMetadata(personMap.get(m.getId()), m)
            .collect(Collectors.toList());