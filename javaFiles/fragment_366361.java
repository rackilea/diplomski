public static void main(String[] args) {

    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    try {
        Class.forName(driver); 
    } catch(java.lang.ClassNotFoundException e) {
        e.printStackTrace();
    }

    final String DATABASE_URL = "jdbc:derby:myDB;create=true;user=user;password=pass";

    try (  
            Connection connection = DriverManager.getConnection(DATABASE_URL, "user", "pass"); 
        )
    {
        // ...
    }
    catch (SQLException sqlException)                                
    {                                                                  
        sqlException.printStackTrace();
    }        

}