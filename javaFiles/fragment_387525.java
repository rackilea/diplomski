String password="pass";
String driver= "net.sourceforge.jtds.jdbc.Driver"; // For sqljdbc4, use: com.microsoft.sqlserver.jdbc.SQLServerDriver
String username="user";
String URL="jdbc:jtds:sqlserver://serverIP:port/dbname"; // For sqljdbc4, use: jdbc:sqlserver://serverIP:port;databaseName=dbname
Class.forName(driver);
Connection conn = DriverManager.getConnection(URL, username, password);

// Use your connection here
// Don't forget to close the connection