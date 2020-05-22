synchronized (players) {
    for (Player player : players) {
        player.update(fcount);
    }
}
...
// down in the outer thread
synchronized (players) {
    players.add(new LocalPlayer(0, 9001, 0, 0, 0, 0, this, null));
}