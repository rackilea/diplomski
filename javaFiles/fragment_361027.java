Set<String> personIds = new LinkedHashSet<>(Arrays.asList("1-NY", "2-CA", "3-MD", "1-TX", "3-VA"));
    Set<String> personNames = new LinkedHashSet<>(Arrays.asList("John-NY", "Bill-CA", "Ron-CA", "Rick-MD", "John-TX", "Rick-VA"));

    Map<String, String> personIdMap = personIds.stream().map(v -> v.split("-"))
            .collect(Collectors.toMap(v -> v[1], v -> v[0]));

    Set<String> combination = new LinkedHashSet<>();
    personNames.forEach(name -> {
        final String[] split = name.split("-");
        final String personId = personIdMap.get(split[1]);
        combination.add(personId + '-' + name);
    });