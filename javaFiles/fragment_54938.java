Connection con = dataSource.getConnection();
try {
    con.setAutoCommit(true);
    PreparedStatement st = con.prepareStatement("SELECT sequenceValue  SequenceValue WHERE sequenceIdentifier = ?");
    st.setString(1, sequenceIdentifier);
    SQLException retried = null;
    for (;;) {
        ResultSet rs = st.executeQuery();
        if (!rs.next()) {
            if (retried != null)
                throw retried;
            PreparedStatement ins = con.prepareStatement("INSERT INTO SequenceValue (sequenceIdentifier, sequenceValue) VALUES (?, ?)");
            ins.setString(1, sequenceIdentifier);
            ins.setLong(2, 0);
            try {
                ins.executeUpdate();
            }
            catch (SQLException ex) {
                // store the exception and rethrow if next query retry fails
                retried = ex;
            }
        }
        else {
            long value = rs.getLong(1);
            PreparedStatement upd = con.prepareStatement("UPDATE SequenceValue SET sequenceValue = sequenceValue+1 WHERE sequenceIdentifier = ? AND sequenceValue = ?");
            upd.setString(1, sequenceIdentifier);
            upd.setLong(2, value+1);
            if (upd.executeUpdate() == 1)                
                return value+1;
        }
    }
}
finally {
    con.close();
}