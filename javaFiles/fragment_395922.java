...
import org.apache.logging.log4j.core.config.Configurator;
...

    private LoggerContext loggerContext;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
       ...
       urlLogConfig = (URL) context.lookup("java:comp/env/"+logLocation);
       ...
       //urlLogConfig -> file:///somepath/log4j.xml
       ServletContext servletContext = servletContextEvent.getServletContext();
       String contextName = servletContext.getServletContextName();
       Classloader classloader = this.getClass().getClassloader();
       loggerContext = Configurator.initialize(contextName, classloader, urlLogConfig.toURI());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.log("Log4jConfigurationListener - Shutting down log4j");
        if (loggerContext != null) 
             Configurator.shutdown(loggerContext);
    }