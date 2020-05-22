public class MyHibernate {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  private static SessionFactory buildSessionFactory() {
    try {
        URL r1 = MyHibernate.class.getResource("/hibernate.cfg.xml");
        Configuration c = new Configuration().configure(r1);

        try {
            InputStream is = MyHibernate.class.getResourceAsStream("/hibernate.properties");
            Properties props = new Properties();
            props.load(is);
            c.addProperties(props);
        } catch (Exception e) {
            LOG.error("Error reading properties", e);
        }

        return c.buildSessionFactory();
    } catch (Throwable ex) {
        LOG.error("Error creating SessionFactory", ex);
        throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}