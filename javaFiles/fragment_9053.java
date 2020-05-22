Player[] getPlayerOrder() {
  Player[] players = playerMap.values().toArray(new Player[playerMap.size()]);
  getPlayerOrder(players, 0, players.length);
  return players;
}

void getPlayerOrder(Player[] players, int start, int end) {
  // Get all players between players[start] (inclusive) and
  // players[end] (exclusive) to re-roll the dice.
  for (int i = start; i < end; ++i) {
    // Logic to roll dice...
    players[i].setDiceNumberRolled(...);
  }

  // Sort this portion of the array according to the number rolled.
  Arrays.sort(players, start, end, new Comparator<Player>() {
    @Override public int compare(Player a, Player b) {
      return Integer.compare(b.getDiceNumberRolled(), a.getDiceNumberRolled());
    }
  });

  // Look for players who rolled the same number.
  int i = start;
  while (i < end) {
    // Try to find a "run" of players with the same number.
    int runStart = i;
    int diceNumberRolled = players[runStart].getDiceNumberRolled();
    ++i;
    while (i < end && players[i].getDiceNumberRolled() == diceNumberRolled) {
      ++i;
    }

    if (i - runStart > 1) {
      // We have found more than one player with the same dice number.
      // Get all of the players with that dice number to roll again.
      getPlayerOrder(players, runStart, i);
    }
  }
}