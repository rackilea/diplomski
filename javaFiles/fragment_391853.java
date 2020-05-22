stmt.executeUpdate(query, new String[] { "flight_id" });
try (ResultSet result = stmt.getGeneratedKeys()) {
    result.next();
    int autoIncKey = result.getInt(1);
    svr.setGeneratedKey(autoIncKey);
    obj.setGeneratedKey(autoIncKey);
}
svr.setRows(1);
svr.setSuccess(true);