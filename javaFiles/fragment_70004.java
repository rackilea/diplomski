List<Entity> nearbyEntities = player.getNearbyEntities(8, 2, 8); // Get entities within 16x4x16 box centered around player
for (Entity entity : nearbyEntities) { // For each Entity found
    if (entity instanceof LivingEntity) { // If the Entity is an instance of a LivingEntity
        LivingEntity living = (LivingEntity) entity; // Cast
        if (isLocationInTriangle(living.getLocation(), player.getLocation(), v2, v3)) { // If the LivingEntity is inside the triangle
            living.damage(6); // Damage the entity (just as an example)
        }
    }
}