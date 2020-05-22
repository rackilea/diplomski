interface Resource {
    ResourceState read();
    void write(ResourceState);
    void dispose();
}

abstract class AbstractResource<T> implements Resource {
    /* This is where the Strategy comes in.
     * The generic ensures compile-time verification of the
     * strategy's type. */
    protected AbstractResource(ResourceStrategy<T> strat) {
        // ...
    }

    // Both the read and write implementations delegate to the strategy.
}

class ExclusiveResource<T> extends AbstractResource<T> { ... }
class ShareableResource<T> extends AbstractResource<T> { ... }

// This is the behaviour the client implements, for custom resources.
public abstract class ResourceStrategy<T> {
    public abstract ResourceState read(T obj);
    public abstract void write(ResourceState state);
    public abstract void dispose(T obj);
}