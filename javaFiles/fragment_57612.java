public static final String urlString = “jdbc:mysql://address=(protocol=tcp)(host=your-ipv6-address)(port=3306)/Library”;
Class.forName(driver);
public static final String user= "user";
public static final String password= "correctpass";
DriverManager.setLoginTimeout(getConnectionTimeOut());
dbConnection = DriverManager.getConnection(urlString,user,password);