public class DefaultBaseEntity <E extends BaseEntity>
        implements BaseEntity<E> {

    private BaseWorld<E> world;

    // ...
}

public class DefaultClientEntity extends DefaultBaseEntity<ClientEntity>
        implements ClientEntity {
    // ...
}