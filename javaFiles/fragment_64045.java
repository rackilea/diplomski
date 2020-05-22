@EventHandler
public void onPlayerMove(PlayerMoveEvent e) {
     Player mover = e.getPlayer();
     Location from = e.getFrom();
     Location to = e.getTo();
     Collection<Entity> nearbyEntities = mover.getWorld().getNearbyEntities(from,  10, 10, 10);//Get entities in a 10 block square from loc "from"
     List<Player> nearbyPlayers = new ArrayList<Player>();
     for (Entity en : nearbyEntities) {
         if (en instanceof Player)
           nearbyPlayers.add((Player) en);
     }
     for (Player victim : nearbyPlayers) {
         if (victim.hasMetadata("isInBubble") && victim != mover) {
            Location victimLoc = victim.getLocation();
            if (victimLoc.distance(to) <= 5) {//Radius 5
                e.setCancelled(true); //Cancel so cant move
                return; //we have nothing left no need to get in for statement again
            }
            }
         }
     }
}