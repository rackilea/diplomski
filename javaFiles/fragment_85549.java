public class EntityHome {

    protected static final Log log = LogFactory.getLog(EntityHome.class);
    protected SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static EntityHome entityHome;

    public static EntityHome getInstance() {
        if (entityHome == null) {
            try {
                entityHome = new EntityHome();
            } catch (Exception e) {
                AppLogger.log("########### unable to configure hibernate,exception is: " + e.getMessage());
                entityHome = null;
            }
        }
        return entityHome;
    }

    private EntityHome() throws Exception {
        try {
            configureHibernate();
        } catch (Exception e) {
            throw e;
        }
    }

    private void configureHibernate() throws HibernateException {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
                .buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public SessionFactory getSessionFactory() throws NamingException {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            configureHibernate();
        }
        return sessionFactory;
    }

    public UserTransaction getTransaction() {

        UserTransaction transaction = null;

        try {
            Object o = new InitialContext().lookup("java:comp/UserTransaction");
            transaction = (UserTransaction) o;
            return transaction;
        } catch (Exception e) {
            throw new IllegalStateException("Could not locate java:comp/UserTransaction in JNDI");
        }
    }

    public static <T> List<T> fromSetToList(Set<T> set) {
        List<T> list = new ArrayList<T>();
        for (T o : set) {
            list.add(o);
        }
        return list;
    }
}