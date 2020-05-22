public class ConnectDatabase {

   Connection dbConnection = null;
   String dbName = "silkopenview";
   String userName = "SilkTestAdmin"; 
   String password = "Nbv12345";

   public Connection getConnection() {
      Class.forName(drivername);
      dbConnection = DriverManager.getConnection(dbName,userName,password);
      return dbConnection;
   }
}