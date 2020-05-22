abstract class Item {
    // insert methods that act exactly the same for all items here

    // now define one that subclasses must fill in themselves
    public abstract void show()
}
class ContainerItem extends Item {
    @Override public void show() {
        // container display logic here instead
    }
}
class WeaponItem extends Item {
    @Override public void show() {
        // weapon display logic here instead
    }
}