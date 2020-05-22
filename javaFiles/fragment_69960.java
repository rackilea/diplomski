for (x = 0; x < alCTeams.size() - 1; x++) {
    // retrieve current wins/losses for team x
    iHTWins = alCTeams.get(x).getWins();
    iHTLosses = alCTeams.get(x).getLosses();

    for (y = x + 1; y < alCTeams.size(); y++) {
        // retrieve current wins/losses for team y
        iVTWins = alCTeams.get(y).getWins();
        iVTLosses = alCTeams.get(y).getLosses();

        for (iGameCount = 0; iGameCount < 2; iGameCount++) {
            // do 2 game stuff
        }
        // store wins/losses for team y back to list
        alCTeams.get(y).setWins(iVTWins);
        alCTeams.get(y).setLosses(iVTLosses);  // set losses, not wins
    }
    // store wins/losses for team x back to list
    alCTeams.get(x).setWins(iHTWins);
    alCTeams.get(x).setLosses(iHTLosses);
}