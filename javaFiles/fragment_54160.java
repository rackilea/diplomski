public void addPlayer(Player player)
{
    if (player != null) {
        player.setTeam(this);  // here is the change
        players.add(player);
    }
}