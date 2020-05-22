public static void conn() throws ClassNotFoundException, SQLException{  
    Connection con=DriverManager.getConnection(  
            "jdbc:oracle:thin:@localhost:1521:orclpdb", "HR", "HR"); 
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select count(*) from dual");  
    while(rs.next())  
        System.out.println(rs.getInt(1));  
    con.close();
}