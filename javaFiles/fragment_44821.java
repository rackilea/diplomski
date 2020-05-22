@EventHandler
public void onProjectileLaunch(ProjectileLaunchEvent e) {
    Projectile projectile = e.getEntity();
    //Make the checks to know if this is the potion you want to cancel
    if (/*conditions*/) e.setCancelled(true);   //Cancels the potion launching
}