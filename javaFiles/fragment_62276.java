public Connection connectDB() {            

    Connection con = null;

    try { 
        Class.forName("com.mysql.cj.jdbc.Driver"); 

         con = DriverManager.getConnection("jdbc:mysql://****/SAC?useSSL=false&serverTimezone=UTC", "***", "***");
    }
    catch(SQLException e) { 
        e.printStackTrace();
    }
    catch(ClassNotFoundException e) {
        e.printStackTrace();
    }

return con;
}