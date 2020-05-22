@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
    if (!(e.getEntity() instanceof Player)) return;
    Player player = (Player) e.getEntity();
    Player damager;
    if (e.getDamager() instanceof Arrow) {
        Arrow a = (Arrow) e.getDamager();
        if (!(a.getShooter() instanceof Player)) return;
        damager = (Player) a.getShooter();
    } else {
        if (!(e.getDamager() instanceof Player)) return;
        damager = (Player) e.getDamager();
    }
    for (Team t : teams2) {
        if ((t.player1 == player || t.player2 == player) && (t.player1 == damager || t.player2 == damager)) {
            e.setCancelled(true);
        }
    }
}