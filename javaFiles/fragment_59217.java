@Stateful // it could work without @Stateful (but Serializable) but I haven't tested enough
@UnitOfWorkScoped
public class EntityManagerProducer {

    @PersistenceContext(type = EXTENDED)
    private EntityManager entityManager;

    @Produces
    @UnitOfWorkScoped
    @TransactionAttribute(NOT_SUPPORTED)
    public EntityManager entityManager() {
        return entityManager;
    }
}