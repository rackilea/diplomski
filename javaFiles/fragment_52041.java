@Repository("appDao")
public class ProductDaoJpa extends GenericDaoJpa<Product> implements ProductDao{

    @Override
    @PersistenceContext(type=PersistenceContextType.TRANSACTION, unitName="mySecondPersistenceUnit")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}