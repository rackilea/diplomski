@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    // Check whether both entities are players
    if (event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
        Player damager = (Player) event.getDamager(); // Player doing the damage
        Player hurt = (Player) event.getEntity(); // Player getting hurt

        int height = 3; // The height you want to check
        Material pvpMaterial = Material.BEDROCK; // The material we are checking for

        boolean belowDamager = isMatBelow(damager, pvpMaterial, height); // Boolean whether a bedrock block is below the damager
        boolean belowHurt = isMatBelow(hurt, pvpMaterial, height); // Boolean whether a bedrock block is below the hurt player
        if (!belowDamager || !belowHurt) { // If there is NO bedrock between the damager or the hurt player
            // Create message -> if there isn't bedrock below the damager, initialize with first string, otherwise use the second string
            String message = (!belowDamager) ? "You are in a no-PVP zone." : "That player is in a no-PVP zone.";
            damager.sendMessage(message);
            event.setCancelled(true);
        }
    }
}