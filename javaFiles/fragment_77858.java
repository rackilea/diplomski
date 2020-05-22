@Test
public void test() {
    Configuration configuration = new Configuration().configure();
    ServiceRegistry serviceRegistry = 
            new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                                        .buildServiceRegistry();
    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    try {
        System.out.println("before");
        News news = new News("Java2", "Sun2", new Date());
        session.save(news);
        System.out.println("after");
    } catch (HibernateException e) {
        transaction.rollback();
        e.printStackTrace(); 
    } finally {
        System.out.println("end");
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}