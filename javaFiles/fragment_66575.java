class TDtest  {
   public static void main(String[] args) {    
      System.out.println(classpath);

      try {
         Class.forName("com.teradata.jdbc.TeraDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         // more error handling..
      }
   }
}