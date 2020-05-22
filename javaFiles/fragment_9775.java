public static void main (String[] args) { 
     new testconnect().run();
 } 

 public void run() {
     con2 = java.sql.DriverManager.getConnection(getConnectionUrl2());
 }