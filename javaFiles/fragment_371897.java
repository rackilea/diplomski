public final class MyAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Application gets started.");
        ServletContext servletContext = event..getServletContext();
        servletContext.setAttribute("someAttribute", "Hello world!");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Application has finished.");
    }
}