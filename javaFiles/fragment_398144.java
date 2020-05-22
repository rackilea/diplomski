private Team[] deepClone(Team[] teams) {
    return Stream.of(teams).map(team -> {
        Team newTeam = new Team();
        return newTeam.getPlayers().addAll(team.getPlayers());
    }).toArray(Team[]::new);
}