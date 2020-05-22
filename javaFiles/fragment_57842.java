package mypackage.listener;

            import javax.servlet.ServletContextEvent;
            import javax.servlet.ServletContextListener;
            import mypackage.dataaccess.PersistenceManager;
            import mypackage.utils.StringMap;

            public class PersistenceManagerSetupListener implements ServletContextListener {

                @Override
                public void contextInitialized(ServletContextEvent servletContextInitEvt) {

                  // This is only a wrapper over HashMap<String, String>
                    StringMap initProperties = new StringMap();

                    // Check the System properties to determine if we are running on cloud
                    // or not, and set up the JDBC driver accordingly.
                    String platform = System.getProperty("com.google.appengine.runtime.version").toLowerCase()
                            .contains("google app engine") ? "cloud" : "dev";
                    initProperties.put("datanucleus.ConnectionURL", System.getProperty(platform + ".db.url"));
                    initProperties.put("datanucleus.ConnectionDriverName", System.getProperty(platform + ".db.driver"));
                    initProperties.put("datanucleus.ConnectionUserName", System.getProperty(platform + ".db.user"));
                    initProperties.put("datanucleus.ConnectionPassword", System.getProperty(platform + ".db.password"));
                    // I implemented password encryption. See Datanucleus' "ConnectionEncryptionProvider" interface documentation.
                  initProperties.put("datanucleus.ConnectionPasswordDecrypter",
                            System.getProperty(platform + ".db.encryptionProvider"));

                    // ***********************************************************************************************************
                    // THESE 2 ARE A MUST-HAVE!!!
                    // ***********************************************************************************************************
                    initProperties.put("datanucleus.identifier.case", System.getProperty("persistencemanager.identifier.case"));
                    initProperties.put("datanucleus.storeManagerType", System.getProperty("persistencemanager.storeManagerType"));
                    // ***********************************************************************************************************

                    initProperties.put("datanucleus.NontransactionalRead",
                            System.getProperty("persistencemanager.NontransactionalRead"));
                    initProperties.put("datanucleus.NontransactionalRead",
                            System.getProperty("persistencemanager.NontransactionalRead"));
                    initProperties.put("datanucleus.NontransactionalWrite",
                            System.getProperty("persistencemanager.NontransactionalWrite"));
                    initProperties.put("datanucleus.singletonEMFForName",
                            System.getProperty("persistencemanager.singletonEMFForName"));
                    initProperties.put("javax.persistence.query.timeout", System.getProperty("persistencemanager.query.timeout"));
                    initProperties.put("datanucleus.datastoreWriteTimeout",
                            System.getProperty("persistencemanager.datastoreWriteTimeout"));


                    // Initialize persistence engine.
                    PersistenceManager.initialize(initProperties);
                }

                @Override
                public void contextDestroyed(ServletContextEvent servletContextDestroyedEvt) {
                    PersistenceManager.shutdown();
                }
            }