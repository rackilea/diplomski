public class MyServletContext implements ServletContextListener{
    ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Context Created");

    }
    public void contextDestroyed(ServletContextEvent contextEvent) {

        System.out.println("Context Destroyed");
    }
}