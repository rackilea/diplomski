public class EntitySubclass extends Entity {

    private Entity parent;

    public EntitySubclass(Entity parent) {
        this.parent = parent;
        // set all data from parent to this entity.
    }

    // fetch the parent object for persistance.
    public Entity getParent() {
        // set all data from this to parent.
    }

    public int getTotal() {
        int iDidMathOnEntityData = 0;
        // do math
        return iDidMathOnEntityData;
    }

}