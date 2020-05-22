public class FilterEnableHibernatePersistenceProvider extends HibernatePersistenceProvider {

    @Override
    public EntityManagerFactory createEntityManagerFactory(String persistenceUnitName, Map properties) {
        return wrapEntityManagerFactory(super.createEntityManagerFactory(persistenceUnitName, properties));
    }

    @Override
    public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map properties) {
        return wrapEntityManagerFactory(super.createContainerEntityManagerFactory(info, properties));
    }

    private EntityManagerFactoryWrapper wrapEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory == null
            ? null
            : new EntityManagerFactoryWrapper(entityManagerFactory);
    }


public static class EntityManagerFactoryWrapper implements HibernateEntityManagerFactory {

    //This is where the filters are being activated
    protected EntityManager initSession(EntityManager entityManager) {
        Session session = ((HibernateEntityManager) entityManager).getSession();
        if (session.getEnabledFilter(FILTER_NAME) == null) {
            Filter activeFilter = session.enableFilter(FILTER_NAME);
            activeFilter.setParameter("some_field", some_value);
        }
        return entityManager;
    }

    // wrapp other methods

}