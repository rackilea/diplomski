public class YourPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }

}