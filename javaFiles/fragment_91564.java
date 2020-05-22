public class AppServletContextListener implements ServletContextListener {

    private static Properties properties = new Properties();

    static {
        // load properties file
        try {
            // absolute path on server outside the war 
            // where properties files are stored

            String absolutePath = ..; 
            File file = new File(absolutePath);
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().
                                    setAttribute("myEnvironment", properties);
    }
}