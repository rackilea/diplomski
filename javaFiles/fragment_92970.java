private class ProjectileCollisionControl extends GhostControl implements PhysicsTickListener {
    public ProjectileCollisionControl(CollisionShape shape) {
        super(shape);
    }

    public void prePhysicsTick(PhysicsSpace space, float tpf) {}

    // Invoked after calculations and after events have been queued
    public void physicsTick(PhysicsSpace space, float tpf) {
        for(PhysicsCollisionObject o : getOverlappingObjects()) {
            Spatial other = (Spatial) o.getUserObject();

            // I just hit a player, remove myself
            if(other.getName().startsWith("Player"))
            {
                space.remove(this);
                space.removeTickListener(this);
            }
        }
    }
}