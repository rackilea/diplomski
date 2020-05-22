list.getFootballTeams()
    .stream()
    .flatMap(team -> team.getFootballers()
                     .stream()
                     .filter(f -> f.getId() == 1)
                     .map(f -> new AbstractMap.SimpleImmutableEntry<>(team, f)))
    .findFirst()
    .ifPresent(e -> {
        FootballTeam targetTeam = e.getKey();
        Footballer targetFootballer = e.getValue();
        // do your action
    });