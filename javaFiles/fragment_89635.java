// try-with-resources statement declaring two resources
try(Connection conn  = DriverManager.getConnection(url,username,password);
    Statement stmt = conn.createStatement()) {
    ...
} catch(SQLException e){
    JOptionPane.showMessageDialog(null, e.toString());
}