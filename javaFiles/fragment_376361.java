private HibernateConnector(boolean db) throws HibernateException {
if (db) {
    cfg = new Configuration();
    cfg.addAnnotatedClass(A.class);
    cfg.addAnnotatedClass(B.class);

    cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    cfg.setProperty("hibernate.connection.url", "jdbc:mysql:XXX");
    cfg.setProperty("hibernate.connection.username", "XXX");
    cfg.setProperty("hibernate.connection.password", "XYZ");
    cfg.setProperty("hibernate.show_sql", "true");
    cfg.setProperty("hibernate.hbm2ddl.auto", "create");
    sessionFactory = cfg.buildSessionFactory();
} else {
    cfg = new Configuration();
    cfg.addAnnotatedClass(A.class);
    cfg.addAnnotatedClass(B.class);
    cfg.addAnnotatedClass(C.class);
    cfg.addAnnotatedClass(D.class);

    cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    cfg.setProperty("hibernate.connection.url", "jdbc:mysql://XXX");
    cfg.setProperty("hibernate.connection.username", "XYZ");
    cfg.setProperty("hibernate.connection.password", "XXX");
    cfg.setProperty("hibernate.show_sql", "true");
    cfg.setProperty("hibernate.hbm2ddl.auto", "update");
    sessionFactory = cfg.buildSessionFactory();
}
}