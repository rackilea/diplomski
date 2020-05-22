String dbPath = "D:/sqlite/MyNewDatabase.sqlite";
Connection conn = null;
try {
   Class.forName("org.sqlite.JDBC");
   conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath;);
}
catch (ClassNotFoundException ex) { 
    ex.printStackTrace();
}
catch (SQLException ex) { 
    ex.printStackTrace();
}
finally {
    try { 
        if (conn != null) { 
            conn.close(); 
        } 
    } 
    catch (SQLException e) { e.printStackTrace(); }
}