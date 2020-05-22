final Box<BukkitTask> taskBox = new Box<BukkitTask>();
taskBox.value = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
    public void run() {
        /* irrelevant code */
        taskBox.value.cancel();
    }
}, 0L, 20L);