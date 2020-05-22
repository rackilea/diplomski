public class HibernateApplicationContextListener 
    implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        HiberUtil.getSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent event) {
        HiberUtil.closeSessionFactory();
    }
}