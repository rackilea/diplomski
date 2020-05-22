double distance = 10D;
Location center = new Location(Bukkit.getWorld("world"), x, y, z);

for (Player player : Bukkit.getOnlinePlayers()) {
    Location location = player.getLocation();
    if (location.distanceSquared(center) <= distance * distance) {
        // Do something
    }
}