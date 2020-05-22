public interface Resource {
    ResourceState read();
    void write(ResourceState);
    void dispose();
}

/* These implement only the locking schemes. */
abstract class ExclusiveResource implements Resource { ... }
abstract class ShareableResource implements Resource { ... }

/* The user extends these for custom content and behaviour. */
public abstract class CustomExclusiveResource
        extends ExclusiveResource { ... }
public abstract class CustomShareableResource
        extends ShareableResource { ... }