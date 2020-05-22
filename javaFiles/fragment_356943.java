Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {
    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (playersAndTimes.containsKey(player.getUniqueId())) {
                if (playersAndTimes.get(player.getUniqueId()) >= 1) {
                    playersAndTimes.put(player.getUniqueId(), playersAndTimes.get(player.getUniqueId()) - 1);
                } else {
                    //The Player's Time Has Expired As The Number Associated With Their UUID In The Hashmap Is Now Equal To 0.
                    //DO SOMETHING
                }
            }
        }
    }
}, 0, 20);