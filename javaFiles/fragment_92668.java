public static Connection conn = DBConnection.getInstance()
    .getConnection();
//Implementation of DBRowSet left as an exercise for the ambitious.
public static JdbcRowSet myrs =  DBRowSet.getInstance(); 

private static void function1() {
    try {
        myrs.setCommand("SELECT * FROM `table1`");
        myrs.execute();
        //result iteration
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
private static void function2() {
    try {
        myrs.setCommand("SELECT * FROM `table2`");
        myrs.execute();
        //result iteration
    } catch (SQLException e) {
        e.printStackTrace();
    }
}