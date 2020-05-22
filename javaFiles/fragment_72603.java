class Super<D extends AbstractDependency> {
    private final D dependency;
    //...
}

class Sub extends Super<Dependency> {
    public Sub() {
        super(new Dependency(...));
    }
}