public class GenericDaoJpa <T extends DomainObject> implements GenericDao<T> {

    @PersistenceContext(type=PersistenceContextType.TRANSACTION, unitName="myPersistenceUnit")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}