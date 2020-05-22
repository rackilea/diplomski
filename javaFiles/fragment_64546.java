public class PropertiesReadingListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        //read properties here...
        event.
          getServletContext().
          setAttribute("db_name", p.getProperty("DATABASE_NAME"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}