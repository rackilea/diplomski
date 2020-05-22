class Logger {     
   private static Logger instance = new Logger(); 
   public static String LOG_LINE_SEPERATOR =  
      System.getProperty("line.separator");
   public static Logger getInstance() {  
          return instance;     
   } 

   public static String logPattern() {
       return null;
   }
}