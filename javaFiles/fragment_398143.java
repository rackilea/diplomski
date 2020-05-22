private Team[] deepClone(Team[] teams) {
    Team[] new_teams = new Team[teams.length];
    for (int i = 0; i < teams.length; i++) {
        new_teams[i] = new Team();
        new_teams[i].getPlayers().addAll(teams[i].getPlayers());
    }
    return new_teams;
}