String updateStatement =
    "update " + dbName + ".COFFEES " +
    "set TOTAL = TOTAL + ? " +
    "where COF_NAME = ?";

    PreparedStatement updateTotal = con.prepareStatement(updateStatement);
    updateTotal.setInt(1, e.getValue().intValue());
    updateTotal.setString(2, e.getKey());