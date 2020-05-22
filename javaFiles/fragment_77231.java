final Map<String, Person> personByName = lis2.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
    lis1.forEach(person -> {
        final Person personFromMap= personByName.get(person.getName());
        if(Objects.nonNull(personFromMap)){
            //copy id, assuming a setId/getId method exist
            person.setId(personFromMap.getId());
        }
    });