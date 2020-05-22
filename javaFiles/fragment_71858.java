public static Connection getInstance() throws Exception {
  if (connection != null && !connection.isClosed()) {
    return connection;
  }
  if (isLocalTesting) {
    //MySQL
    String url = "jdbc:mysql://127.0.0.1:3306/YOUR_DB_NAME";
    connection = DriverManager.getConnection(url, "root", "");
  } else {
    // Google Cloud SQL
    DriverManager.registerDriver(new AppEngineDriver());
    connection = DriverManager.getConnection("jdbc:google:rdbms://" + instanceName + "/NAME_DB");
  }
  return connection;
}