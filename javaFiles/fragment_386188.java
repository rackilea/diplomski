class SoccerTeam {
  @Size(min= 11, max = 11)
  private List<Player> players;
}

class Player {
  @Min(1)
  @Max(11)
  int shirtNumber;
}