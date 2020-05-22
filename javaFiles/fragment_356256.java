/**
 * Open a connection to a MySQL database
 * @param userName      registered user on the MySQL database.
 * @param userPassword  MySQL database password for the named user.
 * @param databaseUrl   database name eg. 'jdbc:mysql://glnd2818898.network.net/matlab'
 */
 public void openMySQLConnection(String userName, String userPassword, String databaseUrl){
    try {
        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
        conn = DriverManager.getConnection (databaseUrl, userName, userPassword);

    }catch (SQLException e) {System.err.println ("Cannot connect to database server");}
 }