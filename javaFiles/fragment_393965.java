int mostWins = teams.get(0).getWins();

// Find the team with the most wins
for(Team team : teams) {
    if (team.getWins() > mostWins) {
        teamWithMostWins = team;
        mostWins = team.getWins(); // <--- Update the most wins every time you find a team with more wins
    }
}