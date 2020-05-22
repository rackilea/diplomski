public static void initialize(Map properties) {
                    if (!isInitialized) {
                        if (properties == null) {
                            emfInstance = Persistence.createEntityManagerFactory("MyPersistenceUnit");
                        } else {
                            emfInstance = Persistence.createEntityManagerFactory("MyPersistenceUnit", properties);
                        }
                        emInstance = emfInstance.createEntityManager();
                        isInitialized = true;
                    }
                }

                public static void shutdown() {
                    try {
                        emInstance.close();
                    } catch (Exception e) {}
                    try {
                        emfInstance.close();
                    } catch (Exception e) {}
                }