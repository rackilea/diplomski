public static SessionFactory getSessionFactory(){
     if (factory == null) {

         try {
             factory = new Configuration().configure().buildSessionFactory();

         } catch (Throwable ex) {
             System.err.println("Failed to create   sessionFactory object." + ex);
             throw new ExceptionInInitializerError(ex);
         }
     }
     return factory;

 }

 public static Session getSession() {
     return getSessionFactory().openSession();
 }