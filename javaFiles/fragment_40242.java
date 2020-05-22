@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Do your job here on application startup.
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Do your job here on application shutdown.
    }

}