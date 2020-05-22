@WebListener
public class SomeClass implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //Put code here
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}