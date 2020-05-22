List<Player> toIterate;
synchronized(players) {
    toIterate = new ArrayList<>(getPlayerList());
}
for(Player player : toIterate) {
    // work
}