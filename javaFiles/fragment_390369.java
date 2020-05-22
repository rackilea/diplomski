public FootballClub(
    int gPlayed, int gWins, int gLosses, int gDraws, int gFor, int gAgainst,
    String inName, String inLocation, int inCapacity
) {
    played = gPlayed;
    wins = gWins;
    losses = gLosses;
    draws = gDraws;
    goalsFor = gFor;
    goalsAgainst = gAgainst;

    // set the variables from the superclass
    name = inName;
    location = inLocation;
    capacity = inCapacity;
}