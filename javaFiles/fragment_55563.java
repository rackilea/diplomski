@EventHandler
   public void onPlayerJoin(PlayerJoinEvent e){ // Removed the extra parameters Player & String
    Player p = e.getPlayer();
    e.setJoinMessage(null);
    Bukkit.broadcastMessage("&e&l" + p.getDisplayName() + "&bJoin Server") //I would recommend doing 'p.getName();' instead of 'p'
    Bukkit.getServer().getLogger().info(p.getDisplayName() + "join server");
    p.sendMessage(getConfig().getString("motd")); // Removed 'e.getPlayer().sendMessage("")'
    p.sendMessage("&aWelcome to Server");
   } // Could not see a close brace here in your code