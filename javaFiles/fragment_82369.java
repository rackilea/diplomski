private void setTarget(Entity e) {
    if (e instanceof Creature) {
        Creature c = (Creature)e;
        // Creature-specific code here
    } else if (e instanceof Building) {
        Building b = (Building)e;
        // Building-specific code here
    }
    // Could add an else for other Entity subclasses (might throw UnsupportedOperationException)
}