int total = 0;
Connection con = null;
try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://ConnectionString");
    // ...
    if (rs.next()) {
        int PriceVar = rs.getInt(1);
        total = PriceVar * rs.getInt(2);
    }
    rs.close();
} catch (ClassNotFoundException ex) {
    Logger.getLogger(WarehouseWebService.class.getName()).log(Level.SEVERE, null, ex);
} catch (SQLException ex) {
    Logger.getLogger(WarehouseWebService.class.getName()).log(Level.SEVERE, null, ex);
} finally {
    if (con != null) {
        con.close();
    }
}
return total;