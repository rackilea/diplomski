Map<String, Integer> teams = new HashMap<>();

String team = "team A";
if(teams.containsKey(team)) {
    teams.put(team, teams.get(team) + 1);
} else {
    teams.put(team, 1);
}