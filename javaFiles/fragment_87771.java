String teamName = args[0];

if (!teams.containsKey(teamName)) {
    teams.put(teamName, new MCWarTeam(teamName, joinKey));
} else {
    // do what you want when the team name was already in the map
}