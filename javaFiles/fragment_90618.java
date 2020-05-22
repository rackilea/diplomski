String sql = "UPDATE tbl_priority SET total = ? where priority = ?";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setLong  (1, WTPty);
    stmt.setString(2, "west");
    stmt.addBatch();

    stmt.setLong  (1, NTPty);
    stmt.setString(2, "north");
    stmt.addBatch();

    stmt.setLong  (1, STPty);
    stmt.setString(2, "south");
    stmt.addBatch();

    stmt.setLong  (1, ETPty);
    stmt.setString(2, "east");
    stmt.addBatch();

    stmt.executeBatch();
}