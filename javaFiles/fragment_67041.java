Map.Entry<FootballTeam,Footballer> target = list.getFootballTeams()
    .stream()
    .flatMap(team -> team.getFootballers()
                     .stream()
                     .filter(f -> f.getId() == 1)
                     .map(f -> new AbstractMap.SimpleImmutableEntry<>(team, f)))
    .findFirst()
    .orElse(null);