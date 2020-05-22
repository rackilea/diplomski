private final List<Player> players = ...;

public void addPlayer(Player player) {
    synchronized(players) {
        players.add(player);
    }
}

public void removePlayer(Player player) {
    synchronized(players) {
        players.remove(player);
    }
}