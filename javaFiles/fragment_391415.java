public class MyContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        OgnlRuntime.setSecurityManager(null);
    }
}