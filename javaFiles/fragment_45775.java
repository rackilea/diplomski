public class DirtyHackedHibernatePersistence extends HibernatePersistence {
    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public EntityManagerFactory createEntityManagerFactory(String persistenceUnitName,
            Map properties) {
        properties.put(AvailableSettings.PROVIDER, HibernatePersistence.class.getName());
        Ejb3Configuration cfg = new Ejb3Configuration().configure(persistenceUnitName, properties);
        if (cfg == null) {
            return null;
        }
        cfg.buildMappings();
        hackConfiguration(cfg);
        return cfg.buildEntityManagerFactory();
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public EntityManagerFactory createContainerEntityManagerFactory(PersistenceUnitInfo info,
            Map properties) {
        properties.put(AvailableSettings.PROVIDER, HibernatePersistence.class.getName());
        Ejb3Configuration cfg = new Ejb3Configuration().configure(info, properties);
        if (cfg == null) {
            return null;
        }
        cfg.buildMappings();
        hackConfiguration(cfg);
        return cfg.buildEntityManagerFactory();
    }

    private void hackConfiguration(Ejb3Configuration cfg) {
        System.out.println("Hacking configuration");
        String noProxyByDefault = cfg.getProperties().getProperty("hibernate.hack.no-proxy-by-default", "false");
        if (Boolean.parseBoolean(noProxyByDefault)) {
            Iterator<?> iter = cfg.getClassMappings();
            while (iter.hasNext()) {
                hackClass((PersistentClass)iter.next());
            }
        }
    }

    private void hackClass(PersistentClass classMapping) {
        Iterator<?> iter = classMapping.getPropertyIterator();
        while (iter.hasNext()) {
            Property property = (Property)iter.next();
            if (property.getValue() instanceof ToOne) {
                ToOne toOne = (ToOne)property.getValue();
                if (toOne.isLazy()) {
                    toOne.setUnwrapProxy(true);
                }
            }
        }
    }
}