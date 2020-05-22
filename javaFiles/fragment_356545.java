int iVal = 0;
ResultSet rs = magicallyAppearingStmt.executeQuery(query);
if (rs.next()) {
    iVal = rs.getInt("ID_PARENT");
    if (rs.wasNull()) {
        // handle NULL field value
    }
}