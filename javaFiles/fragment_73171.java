String userTeam = "...";
if(teams.containsKey(userTeam)) {
    System.out.println(userTeam + ": " + teams.get(userTeam));
} else {
    System.out.println(userTeam + " unknown");
}