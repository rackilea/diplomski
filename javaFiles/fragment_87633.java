public void onPlayerMove(PlayerMoveEvent e)
{ // On player movement!
    if((int) e.getPlayer().getLocation().getX() == 300)
    // If you cast as int 3.9 or 3.01 it will return 3
    {
        e.getPlayer().teleport(new Location(Bukkit.getWorld("world"), 310, 75, 300));
        /* There is a bug in bukkit plugins since 1.6.4.
         * You need to get the world just by getWorld(); not
         *  getServer().getWorld();
         */
    }
}