@Stateless
public class TestBean implements TestBusiness {

    @PersistenceContext(unitName = "puTest")
    EntityManager entityManager = null;

    public List method() {
        Query query = entityManager.createQuery("select t FROM Table t");
        return query.getResultList();
    }
}