public static void databaseConnect(String dbName) throws Exception {

   File file = new File (dbName);

  if(file.exists()) //here's how to check
     {
         System.out.print("This database name already exists");
     }
     else{

           Class.forName("SQLite.JDBCDriver").newInstance();            
           conn = DriverManager.getConnection("jdbc:sqlite:/"+ dbName);
           stat = conn.createStatement(); 

     }