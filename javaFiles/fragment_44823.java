@EventHandler
public void onProjectileLaunch(ProjectileLaunchEvent e) {
    Projectile projectile = e.getEntity();

    if (projectile instanceof ThrownPotion) {
       //It's a Potion
       ThrownPotion pot = (ThrownPotion) projectile;
       Collection<PotionEffect> effects = pot.getEffects();
       for (PotionEffect p : effects) {
           if (p.getType().equals(PotionEffectType.INSTANT_HEAL)){
               e.setCancelled(true);
               break;
           }
       }
    }
}