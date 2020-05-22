public class HibernateUtil {
    private static SessionFactory factory = initFactory();

    @SuppressWarnings("deprecation")
    private static initFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getDefaultSession() {
        return factory;
    }
}