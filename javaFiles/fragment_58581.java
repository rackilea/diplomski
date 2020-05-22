try (Stream<Record5<UUID, UUID, String, Integer, String>> stream = valuesToQuery
        .stream()
        .map(this::getSelectQueryForValue)
        .reduce(Select::union)
        .stream() // JDK 9 method
        .flatMap(Select::fetchStream)) {
    ...
}