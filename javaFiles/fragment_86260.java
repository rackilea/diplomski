/*
 * Code
 */
try(
        PreparedStatement ps = conn.prepareStatement(
            "insert into yourTable(field1, field2, field3) values (?,?,?)"
) {
    for(int i = 0; i < 10; i++) {
        ps.setString(1, "abc");
        ps.setInt(2, 123 * i);
        ps.setDouble(3, 3.1416);
        ps.addBatch(); // The insert is added to a batch, pending for execution
    }
    ps.executeBatch(); // All the inserts added to the batch are executed.
} catch(SQLException e) {
    // Your exception handling code
}