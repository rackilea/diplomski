public class BeforeService {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void before() {
        entityManager.persist(new Entity1(...));
        entityManager.persist(new Entity2(...));
    }
}