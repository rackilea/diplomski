public class Config implements ServletContextListener {

    private static final String ATTRIBUTE_NAME = "com.example.Config";
    private Map<Long, Product> products;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute(ATTRIBUTE_NAME, this);
        String dbname = context.getInitParameter("dbname");
        products = Database.getInstance(dbname).getProductDAO().map();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP.
    }

    public static Config getInstance(ServletContext context) {
        return (Config) context.getAttribute(ATTRIBUTE_NAME);
    }

    public Map<Long, Product> getProducts() {
        return products;
    }

}