public final class YourClass {
    ...
    private final Super parent; // only once
    public YourClass(Super parent, ...) {
        ...
        this.parent = parent;
    }
}