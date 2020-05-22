public class JpaCrudRepository<T, PK extends Serializable> implements CrudRepository<T, PK> {
    private boolean flushOnCreate = true

    public JpaCrudRepository(boolean flushOnCreate) {
        this.flushOnCreate = flushOnCreate;
    }


     /**
     * Persist the given entity to repository and flushes all instructions if isFlushOnCreate() == true
     * @param entity persisted entity
     */
    @Override
    public void create(T entity) {
        entityManager.persist(entity);
        if (flushOnCreate) {
            entityManager.flush();
        }
    }
}

@Repository
public class JpaUserRepository extends JpaCrudRepository<User, Long> implements UserRepository {

    public JpaUserRepository() {
        super(true);
    }
    .....
}