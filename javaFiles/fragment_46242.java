public static final String DB_URL = "jdbc:sqlite:database.db";  
public static final String DRIVER = "org.sqlite.JDBC";  

public static Connection getConnection() throws ClassNotFoundException {  
    Class.forName(DRIVER);  
    Connection connection = null;  
    try {  
        SQLiteConfig config = new SQLiteConfig(); //I add this configuration 
        config.enforceForeignKeys(true);  
        connection = DriverManager.getConnection(DB_URL,config.toProperties());  
    } catch (SQLException ex) {}  
    return connection;  
}