public abstract class AbstractEntity<I, E extends AbstractEntity<I, E>> implements Comparable<E> {
    ...
    private I id;
    private String name;
    ...
    public final String getName() {
        return name;
    }
    ...
    @Override
    public int compareTo(E otherEntity) {
        final String otherName = otherEntity.getName();
        ...
    }
}

public final class User extends AbstractEntity<Long, User> { }