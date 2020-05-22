public class HibernatePersistenceExtensions extends HibernatePersistence {

    @Override
    public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info, Map map) {

        if ("true".equals(map.get("hibernate.use.custom.entity.manager.factory"))) {
            return CustomeEntityManagerFactoryFactory.createCustomEntityManagerFactory(info, map);
        } else {
            return super.createContainerEntityManagerFactory(info, map);
        }
    }
}