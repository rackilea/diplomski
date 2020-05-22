public abstract class AbstractFacade<E extends Serializable, 
                                     PK extends Serializable> {

    private final transient Class<E> entityClass;

    public AbstractFacade(final Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(final E entity) {
        final EntityManager entityManager = getEntityManager();
        entityManager.persist(entity);
    }

    public final E find(final PK id) {
        return getEntityManager().find(entityClass, id);
    }

    // Other common operations

}