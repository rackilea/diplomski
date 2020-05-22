import org.apache.log4j.Logger;
    import org.mule.api.MuleEventContext;
    import org.mule.api.lifecycle.Callable;   

    public class MyClass implements Callable {
       private static Logger logger = Logger.getLogger(MyClass.class);
       private String server;
       private Properties properties;

       public MyClass() {  }

       @Override
       public Object onCall(MuleEventContext eventContext) throws Exception {
           properties = loadProperties("application.properties");
           server = properties.getProperty("server.address");
           logger.info("Server is " + server);
           return null;
       }

       public Properties loadProperties(String name) {
            if(properties == null){
                return loadProperties(name, Thread.currentThread().getContextClassLoader());
            } else {
               return properties;
            }
        }
   }