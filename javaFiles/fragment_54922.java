String sql = "SELECT colA, colB, colC " + 
"FROM " + tblName + " WHERE UserId = ?" + 
" AND InsertTimestamp BETWEEN ?" + 
" AND ? ORDER BY UserId, Occurred";
try {
    if(null == conn) {
        openDatabaseConnection();
    }
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, userId);
    stmt.setDate(2, lastDate);
    stmt.setDate(3, DataProcessor.TODAY);
    ResultSet rs = stmt.executeQuery();  
    retArray = this.getArrayListFromResultSet(rs);
} catch(SQLException sqle) {
    JSONObject parms = new JSONObject();
    eh.processSQLException(methodName, sqle, sql, parms);
}