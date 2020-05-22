Predicate<Person> condition = SearchUtils.and(
        SearchUtils.extractThenFilter(
            Person::getFirstName, 
            str -> "John".equalsIgnoreCase(str)),
        SearchUtils.extractThenFilter(
            Person::getLastName, 
            "tornabone"::equalsIgnoreCase), // just another way
        SearchUtils.extractThenFilter(
            Person::getAddress, 
            str -> str.toLowerCase().contains("poland")));

List<Person> matching = people.values().stream()
    .filter(condition)
    .collect(Collectors.toList());