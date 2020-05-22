public class WorldGuard extends WorldGuardPlugin
{
  public static WorldGuard getFromPlugin(Plugin parent)
  {
    return (WorldGuard) parent.getServer().getPluginManager().getPlugin("WorldGuard");
  }
}