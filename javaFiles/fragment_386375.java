public class MyServletContextListener implements ServletContextListener {
    @Override    // this one gives a compiler error because it doesn't override anything
    public void contextInitilized(ServletContextEvent event) {
        // . . .
    }

    @Override    // this one doesn't complain because it does override a method
    public void contextInitialized(ServletContextEvent event) {
        // . . .
    }

    // this one compiles just fine, even though the name is spelled wrong
    public void contextInitilized(ServletContextEvent event) {
        // . . .
    }

    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }
}