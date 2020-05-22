Predicate<Person> condition = SearchUtils.extractThenFilter(
        Person::getAddress, 
        address -> address.toLowerCase().contains("uk"));

List<Person> matching = people.values().stream()
    .filter(condition)
    .collect(Collectors.toList());