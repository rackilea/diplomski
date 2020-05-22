@EventHandler
public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

    if(!(event.getDamager() instanceof Player) || !(event.getEntity() instanceof Player) ) return;

    String damagerName = event.getDamager().getName();
    String victimName = event.getEntity().getName();

    damageCheck.put(victimName, damagerName);

    Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------[ X ]-------------");
    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + damagerName + ChatColor.GRAY + " is the damager");
    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + victimName + ChatColor.GRAY + " is the victim");
    Bukkit.broadcastMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "-------------[ X ]-------------");

    Bukkit.getLogger().info(damageCheck.toString());

}