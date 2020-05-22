valuesToQuery
    .stream()
    .map(this::getSelectQueryForValue)
    .reduce(Select::union)
    .ifPresent(s -> {
        try (Stream<Record5<UUID, UUID, String, Integer, String>> stream = 
             s.fetchStream()) {
            ...
        }
    })