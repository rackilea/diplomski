String dbServer="DBSERVER";
    String port="1521";
    String SID="DBNAME";
    String url = "jdbc:oracle:thin:@"+dbServer+":"+port+":"+SID;
    Driver driver = new oracle.jdbc.OracleDriver();
    DriverManager.registerDriver(driver);
    Properties props = new Properties();
   //props.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_VSESSION_OSUSER,osUser);
    Connection conn = DriverManager.getConnection(url, props);