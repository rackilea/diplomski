StudentDetails studentDetails = map.entrySet().stream()
        .flatMap(statusEntry -> statusEntry.getValue().entrySet().stream()
                .map(ageEntry -> new AbstractMap.SimpleEntry<Integer, StudentDetails>(
                        ageEntry.getValue().getAge(),
                        new StudentDetails(
                                ageEntry.getKey(), 
                                statusEntry.getKey(), 
                                ageEntry.getValue().getName())))
        ).sorted(Comparator.comparingInt(Map.Entry::getKey))
        .findFirst()
        .map(Map.Entry::getValue)
        .get();