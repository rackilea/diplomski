@WebListener
public class StartupListener implements ServletContextListener {

    @Override 
    public void contextInitialized(ServletContextEvent event) {
        List<Product> products = loadItSomehow();
        event.getServletContext().setAttribute("products", products);
    }

    // ...
}