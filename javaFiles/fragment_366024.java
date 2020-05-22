boolean usingHibernate = false;

for (PersistenceProvider p : providers) {
    if (p.getClass().getName().startsWith("org.hibernate")) {
        usingHibernate = true;
        break;
    }
}