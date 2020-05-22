public static List<Person> constructPersons(
            final String[] firstNames,
            final String[] lastNames) {
        if (firstNames.length != lastNames.length) {
            throw new IllegalArgumentException("firstNames and lastNames must have same length");
        }
        return IntStream.range(0, firstNames.length)
                .mapToObj(index -> Person.of(firstNames[index], lastNames[index]))
                .collect(Collectors.toCollection(ArrayList::new));
    }