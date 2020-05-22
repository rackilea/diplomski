public abstract class MyAbstractChild {
    private final Child child;

    public AbstractChild(final Child child) {
        this.child = child;
    }

    public Child getChild() {
        return child;
    }
}