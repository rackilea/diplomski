List<String> allIds = Stream.of(
    person.baseballPlayers.stream().map(BaseballPlayer::getId),
    person.mmaFighters.stream().map(MmaFighter::getId),
    person.rugbyPlayers.stream().map(RugbyPlayer::getId))
    .flatMap(Function.identity())
    .collect(Collectors.toList());