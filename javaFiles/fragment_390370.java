// in SportsClub
protected SportsClub(
    String inName, String inLocation, int inCapacity
) {
    name = inName;
    location = inLocation;
    capacity = inCapacity;
}

// in FootballClub
public FootballClub(
    int gPlayed, int gWins, int gLosses, int gDraws, int gFor, int gAgainst,
    String inName, String inLocation, int inCapacity
) {
    super(inName, inLocation, inCapacity);

    played = gPlayed;
    wins = gWins;
    losses = gLosses;
    draws = gDraws;
    goalsFor = gFor;
    goalsAgainst = gAgainst;
}