public class SpringApplicationContextListener implements ServletContextListener {
        @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        sce.getServletContext().setAttribute("applicationContext", ac);            
    }
    ... // contextDestroyed
}