public static boolean isMatBelow(Player player, Material material, int depth) {
    Location location = player.getLocation().clone(); // Cloned location
    for (int blocks = 1; blocks <= depth; blocks++) { // From 1 to depth
        location.subtract(0, 1, 0); // Move one block down
        if (location.getBlock().getType() == material) { // If this is the material -> return true (break/exit loop)
            return true;
        }
    }
    return false; // No such material was found in all blocks -> return false
}