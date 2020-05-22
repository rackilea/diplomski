List<String> allIds = Stream.of(
    person.baseballPlayers.stream().map(p -> p.getId()),
    person.mmaFighters.stream().map(p -> p.getId()),
    person.rugbyPlayers.stream().map(p -> p.getId()))
    .flatMap(s -> s)
    .collect(Collectors.toList());