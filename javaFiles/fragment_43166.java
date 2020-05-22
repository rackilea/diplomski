public class DefaultCommonsPooledObject<T> extends DefaultPooledObject<T> {

private final UUID id = UUID.randomUUID();

/**
 * Create a new instance that wraps the provided object so that the pool can track the state of the pooled object.
 * 
 * @param object The object to wrap
 */
public DefaultCommonsPooledObject(T object) {
    super(object);
}

@Override
public boolean equals(Object o) {
    if (this == o)
        return true;
    if (!(o instanceof DefaultCommonsPooledObject))
        return false;

    DefaultCommonsPooledObject that = (DefaultCommonsPooledObject) o;

    if (id != null ? !id.equals(that.id) : that.id != null)
        return false;

    return true;
}

@Override
public int hashCode() {
    return id != null ? id.hashCode() : 0;
}