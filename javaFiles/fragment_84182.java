for (Player player : Bukkit.getOnlinePlayers()) {
    Location location = player.getLocation();
    if (location.distanceSquared(center) <= distance * distance) {
        // Do something
    }
}