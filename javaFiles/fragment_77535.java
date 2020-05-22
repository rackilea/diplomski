private PlayerPoints playerPoints;

/**
 * Validate that we have access to PlayerPoints
 *
 * @return True if we have PlayerPoints, else false.
 */
private boolean hookPlayerPoints() {
    final Plugin plugin = this.getServer().getPluginManager().getPlugin("PlayerPoints");
    playerPoints = PlayerPoints.class.cast(plugin);
    return playerPoints != null; 
}

/**
 * Accessor for other parts of your plugin to retrieve PlayerPoints.
 *
 * @return PlayerPoints plugin instance
 */
public PlayerPoints getPlayerPoints() {
    return playerPoints;
}