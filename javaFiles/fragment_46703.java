public class World {
    List<Entity> entities;

    public void removeItem(Entity entity) {
        entities.remove(entity);
    }
}

public class Entity{
    public void removeSelfFromList() {
        world.removeItem(this);
    }
}