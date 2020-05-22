@EventHandler
public void onInventoryClick(InventoryClickEvent event) {
    Material[] bannedItems = { Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS };
    Player player = (Player) event.getWhoClicked();

    for(Material m : bannedItems) { //Loop thru all elements
        if(player.getInventory().contains(m, 1)){ //Check if in inventory
            player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "RPG" + ChatColor.GRAY + "] " + ChatColor.RED + "A has been removed from your possession.");
            //Remove stuff
        }
    }
}