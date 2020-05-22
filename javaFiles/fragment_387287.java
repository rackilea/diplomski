public class CustomServletContextListener implements ServletContextListener {

    private EntityManagerFactory entityManagerFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        entityManagerFactory = Persistence.createEntityManagerFactory("UnitName");
        context.setAttribute("someKey", entityManagerFactory);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* Some method that cleanly destroys
         * your entity manager factory */
        closeEntityManagerFactory();
    }
}