public class YourClassName implements ServletContextListener{


    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    run your background stuff
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    stop your background stuff

    }
}