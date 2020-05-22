public static List<Entity> getEntitiesAroundPoint(Location location, double radius) {
    List<Entity> entities = new ArrayList<Entity>();
    World world = location.getWorld();

    // To find chunks we use chunk coordinates (not block coordinates!)
    int smallX = MathHelper.floor((location.getX() - radius) / 16.0D);
    int bigX = MathHelper.floor((location.getX() + radius) / 16.0D);
    int smallZ = MathHelper.floor((location.getZ() - radius) / 16.0D);
    int bigZ = MathHelper.floor((location.getZ() + radius) / 16.0D);

    for (int x = smallX; x <= bigX; x++) {
        for (int z = smallZ; z <= bigZ; z++) {
            if (world.isChunkLoaded(x, z)) {
                entities.addAll(Arrays.asList(world.getChunkAt(x, z).getEntities())); // Add all entities from this chunk to the list
            }
        }
    }

    // Remove the entities that are within the box above but not actually in the sphere we defined with the radius and location
    // This code below could probably be replaced in Java 8 with a stream -> filter
    Iterator<Entity> entityIterator = entities.iterator(); // Create an iterator so we can loop through the list while removing entries
    while (entityIterator.hasNext()) {
        if (entityIterator.next().getLocation().distanceSquared(location) > radius * radius) { // If the entity is outside of the sphere...
            entityIterator.remove(); // Remove it
        }
    }
    return entities;
}