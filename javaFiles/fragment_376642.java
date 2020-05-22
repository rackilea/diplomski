public class Animal<T extends Animal> extends Lifeform {
    protected final Class<T> childClass;
    T child;

    public Animal(Class<T> childClass) {
        this.childClass = childClass;
    }

    protected void initiate() {
        setChild(childClass);
    }

    public void setChild(Class<T> animalType) {
        T foundChild = findChild(animalType);
        foundChild.setParent(this);
        this.child = foundChild;
    }
}