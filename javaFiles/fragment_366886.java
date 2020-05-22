public void removePlayer(Player player) {
    if (players.contains(player))
    {
        players.remove(player);
        player.leaveTeam();
        // Do other admin work when a player leaves
    }
}