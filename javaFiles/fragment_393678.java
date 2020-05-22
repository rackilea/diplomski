String sql_main = getSql(sb2.toString());
try (PreparedStatement p_stmt1 = db.getPreparedStatement(sql_main)) {
    for (Map.Entry pair : map.entrySet()) {
        log.debug(pair.getKey() + " = " + pair.getValue());
        int bind_index = 0;
        p_stmt1.setString(++bind_index, (String)pair.getKey());
        p_stmt1.setString(++bind_index, (String)pair.getValue());
        p_stmt1.setString(++bind_index, strGMTDate + " " + strGMTTime);
        p_stmt1.setString(++bind_index, strGMTDate + " " + strGMTTime);
        try (ResultSet resultSet = p_stmt1.executeQuery()) {
            if (resultSet.next()) {

                // Capture/use values from resultSet here

                break;
            }
        }
    }
}