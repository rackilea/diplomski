public void testUUID() throws SQLException {
    UUID uuid = UUID.randomUUID();
    PreparedStatement ps = _conn.prepareStatement("INSERT INTO uuidtest VALUES (?)");
    ps.setObject(1, uuid, Types.OTHER);
    ps.executeUpdate();
    ps.close();

    Statement stmt = _conn.createStatement();
    ResultSet rs = stmt.executeQuery("SELECT id FROM uuidtest");
    assertTrue(rs.next());

    UUID uuid2 = (UUID)rs.getObject(1);
    assertEquals(uuid, rs.getObject(1));
    assertEquals(uuid.toString(), rs.getString(1));

    rs.close();
    stmt.close();
}