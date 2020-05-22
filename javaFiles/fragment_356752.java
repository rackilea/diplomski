public MyTask (antirelog plugin)
{
    this.plugin = plugin;
    if (plugin != null) {
        id = plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin,this,plugin.getConfig().getInt("StunDuration") * 20);
        if (id == -1)
        {
            plugin.getLogger().warning("BLARG");
        }
    }
}

//public MyTask() //Remove the void, this is a constructor
//{
//  this(null); //Call the extended constructor
//}