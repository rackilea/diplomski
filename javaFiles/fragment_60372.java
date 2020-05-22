public EntityManagerFactory createEntityManagerFactory(Configuration hibConfiguration) {
    Properties p = hibConfiguration.getProperties();

    // convert to Map
    Map<String, String> pMap = new HashMap<>();
    Enumeration<?> e = p.propertyNames();
    while (e.hasMoreElements()) {
        String s = (String) e.nextElement();
        pMap.put(s, p.getProperty(s));
    }

    // create EntityManagerFactory
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("some persistence unit", pMap);

    return emf;
}