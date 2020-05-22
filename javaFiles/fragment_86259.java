/*
 * Code
 * I am assuming that you have a Connection object named conn.
 * This is just a simple example
 */
try(
        PreparedStatement ps = conn.prepareStatement(
            "insert into yourTable(field1, field2, field3) values (?,?,?)"
) {
    /*
     * The question marks are placeholders for the values you will insert.
     */
    ps.setString(1, "abc");
    ps.setInt(2, 123);
    ps.setDouble(3, 3.1416);
    ps.execute(); // The insert is executed here
} catch(SQLException e) {
    // Your exception handling code
}