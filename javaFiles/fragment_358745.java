@EventHandler
public void onTnt(PlayerInteractEntityEvent e) {
    Player clicker = e.getPlayer();
    // Needs to be final to reference it later
    final Player rightclick = (Player) e.getRightClicked();
    rightclick.sendMessage(ChatColor.GRAY + "~" + ChatColor.DARK_PURPLE + "AN INSTAKILLER HAS YOU AS A TARGET! SNEAK NOW!");
    rightclick.sendMessage(ChatColor.GRAY + "~" + ChatColor.DARK_RED + "AN INSTAKILLER HAS YOU AS A TARGET! SNEAK NOW!");
    rightclick.sendMessage(ChatColor.GRAY + "~" + ChatColor.GOLD + "AN INSTAKILLER HAS YOU AS A TARGET! SNEAK NOW!");


    BukkitRunnable task = new BukkitRunnable() {
        @Override
        public void run() {
            if (!(rightclick.isSneaking()))  {
                rightclick.sendMessage(ChatColor.GRAY + "~" + ChatColor.GOLD + "Bye bye.");
                rightclick.setHealth(0);
            }
        }
    };
    // Run the task on this plugin in 3 seconds (60 ticks)
    task.runTaskLater(this, 20 * 3);
}