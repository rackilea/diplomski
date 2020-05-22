BukkitTask task;

public void playerDead() {
    // Command here
    if (task != null) {
        task.cancel();
    }
    task = getServer().getScheduler().runTaskLater(Plugin, new Task(), 2400L);
}