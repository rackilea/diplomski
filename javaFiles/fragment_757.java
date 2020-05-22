public abstract class C {
    private static final InstanceManager<C> manager = new InstanceManager<C>();

    protected C() {
        manager.manage(this);
    }
}