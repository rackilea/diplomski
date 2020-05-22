Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:MsAccessDSN");
Statement stmt = con.createStatement();
// Specify the type of object; in this case we want tables
String[] types = {"TABLE"};
ResultSet checkTable = con.getMetaData().getTables(null, null, "%", types);
String tableName = null;

while (checkTable.next())
{
    System.out.println("In here");
    tableName = checkTable.getString(3)
    System.out.println(tableName);

    // check if the table 'data_table' exist in your database
    if (tableName.equals("data_table"){    
        try {
            //drop the table if present  
            int temp = stmt.executeUpdate("DROP TABLE " + tableName);
            break;
        }
        catch (Exception e) {
            System.err.println("Exception in testDropTable (): \n"
                + "Drop Table testDropTable threw an exception: " +(e.getMessage()));
        }
    }    
}
con.close;