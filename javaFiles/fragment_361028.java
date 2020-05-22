Set<String> personIds = new LinkedHashSet<>(Arrays.asList("1-NY", "2-CA", "3-MD", "1-TX", "3-VA"));
    Set<String> personNames = new LinkedHashSet<>(Arrays.asList("John-NY", "Bill-CA", "Ron-CA", "Rick-MD", "John-TX", "Rick-VA"));

    Map<String, String> personIdMap = new HashMap<>();
    for (String id : personIds) {
        final String[] split = id.split("-");
        personIdMap.put(split[1], split[0]);
    }

    Set<String> combination = new LinkedHashSet<>();
    for (String name : personNames) {
        final String[] split = name.split("-");
        final String personId = personIdMap.get(split[1]);
        combination.add(personId + '-' + name);
    }