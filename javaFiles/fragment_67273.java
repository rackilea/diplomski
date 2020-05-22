String insert = "INSERT INTO queries (data_id, query, query_name," +
        " query_file_name, status) VALUES (?,?,?,?,?)";

PreparedStatement stmt = dbconn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
// Why do you set this if you want the DB to generate it?
stmt.setInt(1, currentDataID); // or setLong() depending on data type
stmt.setString(2, params[1]); // I assume params is a String[]
stmt.setString(3, params[2]);
stmt.setString(4, params[3]);
stmt.setString(5, params[4]);
stmt.execute();

ResultSet rs = stmt.getGeneratedKeys();
if (rs.next()) {
    // if it's an int, avoid the cast and use rs.getInt(1) instead
    currentDataID = (int) rs.getLong(1);
}