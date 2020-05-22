private void setTarget(Entity e) {
    if (e instanceof Creature) {
        Creature c = (Creature)e;
        c.setTarget();
    } else if (e instanceof Building) {
        Building b = (Building)e;
        b.setTarget();
    }
    // Could add an else for other Entity subclasses (might throw UnsupportedOperationException)
}