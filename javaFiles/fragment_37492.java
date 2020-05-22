public class DataAccess {
    private Connection con;
    private static final String myTable = "MY_TABLE";
    public DataAccess()
            throws SQLException, ClassNotFoundException {
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("jdbc:ucanaccess://" + 
                        "D:/BlueDb/db/db1.mdb");
    }
    public void closeDb()
            throws SQLException {
        con.close();
    }
    public void printAllRows()
            throws SQLException {
        String sql = "SELECT * FROM " + myTable;
        try(Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(sql)) {
            while (rs.next()) {
                int i = rs.getInt("id");
                String s = rs.getString("name");
                System.out.println(i + " :: " + s);
            }
        }   
    }
}