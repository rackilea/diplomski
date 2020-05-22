public class YourPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        //your event
    }

}