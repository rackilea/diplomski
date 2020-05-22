rows = stmt.executeUpdate(query, new String[] { "flight_id" });
int autoIncKey = -1;
if (rows > 0) {
    result = stmt.getGeneratedKeys();
    if (result.next()) {
        autoIncKey = result.getInt(1);
    }
}
svr.setGeneratedKey(autoIncKey);
obj.setGeneratedKey(autoIncKey);
svr.setRows(rows); //Insert/Update/Delete
svr.setSuccess(rows > 0);