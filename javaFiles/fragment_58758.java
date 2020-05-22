public class Config implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        URL url = event.getServletContext().getResource(fileName);
        // ...
    }

    // ...
}