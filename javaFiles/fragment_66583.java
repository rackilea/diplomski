// fill in the prepared statement and
pInsertOid.executeUpdate();
ResultSet rs = pInsertOid.getGeneratedKeys();
if (rs.next()) {
  int newId = rs.getInt(1);
  oid.setId(newId);
}