Map<String, Person> oldestPeopleByName = 
    names2PeopleAges.entrySet()
                    .stream()
                    .collect (Collectors.toMap(e->e.getKey(),
                                               e->e.getValue().lastEntry().getValue())
                             );