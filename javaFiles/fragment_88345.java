@TransactionManagement(TransactionManagementType.BEAN)
public class PersistableProcessStepStatus extends ProcessStepStatus {
@PersistenceUnit(unitName = "second")
private EntityManagerFactory entityManagerFactory;

private void changeFlag(String namedQuery, String flag, boolean enable) {
    entityManager = entityManagerFactory.createEntityManager();

    entityManager.getTransaction().begin();
    entityManager.createNamedQuery(namedQuery)
            .setParameter("a", prozessName)
            .setParameter("b", vorgangName)
            .setParameter(flag, enable).executeUpdate();
    entityManager.getTransaction().commit();