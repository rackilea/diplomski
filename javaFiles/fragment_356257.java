private static final String accessDBURLPrefix = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
    private static final String accessDBURLSuffix = ";READONLY=true}";

    /**
     * Open a connection to a Access database
     * @param userName      registered user on the Access database.
     * @param userPassword  Access database password for the named user.
     * @param databaseUrl   database name eg. 'pathname/accessName.mdb'
     */
public void openConnAccess(String userName, String userPassword, String databaseUrl){
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                    String dbUrl = accessDBURLPrefix + databaseUrl + accessDBURLSuffix;
        conn = DriverManager.getConnection (dbUrl, userName, userPassword);
    }catch (SQLException e) {System.err.println ("Cannot connect to database server  :" + e.getMessage());}
}