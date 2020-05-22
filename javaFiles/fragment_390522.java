public class MyContextListener implements javax.servlet.ServletContextListener {

    private static fWeeklyScheduledMail wsm = 
            weeklyScheduledMail.INSTANCE;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
            wsm.startThread();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        wsm.stopThread();
    }
}