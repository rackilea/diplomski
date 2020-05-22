List<Team> teams = table.values()
        .stream()
        .sorted(...)
        .collect(Collectors.toList());

StringBuilder sb = new StringBuilder();
for(int i=0; i<teams.size(); i++) {

    Team team = teams.get(i);
    sb.append(String.format("%2d. %-15s%5d%5d%5d%5d%5d\n", 
            i,
            team.getName(),
            team.getPlayed(),
            team.getWins(),
            team.getDraws(),
            team.getLosses(), 
            team.getPoints()));
}

System.out.println(sb.toString());