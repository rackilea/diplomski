@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

   Entity damager = event.getDamager();

   if(damager instanceof Arrow) { // check if the damager is an arrow

       Arrow arrow = (Arrow) damager;
       if(arrow.getShooter() instanceof Player) {
            // the arrow.getShooter() here is the player who fired the arrow
       }

       Entity entityHit = event.getEntity();
       if(entityHit instanceof Player) {
           Player playerHit = (Player) entityHit;
           // playerHit here is the player who got hit
       }

}