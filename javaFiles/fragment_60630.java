Statement s = conn.createStatement();
s.addBatch("CALL INSERT_AUTONUMBER_DATA(......)");
s.addBatch(.....);
.
.
.

s.executeBatch();