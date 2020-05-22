/**
 * Export the SQL results
 * @param resultSet {@link java.sql.ResultSet}
 * @return {@link ArrayList<ArrayList>} with {@link java.lang.String}
 * @throws SQLException
 */
private ArrayList<ArrayList<String>> exportSQLResult(ResultSet resultSet) throws SQLException{
    ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    ArrayList<String> tmpLine;
    resultSet.beforeFirst();
    ResultSetMetaData md = resultSet.getMetaData();
    int cols = md.getColumnCount();

    tmpLine = new ArrayList<String>();
    for(int i=1; i<=cols; ++i){
        tmpLine.add(md.getColumnLabel(i));
    }
    results.add(tmpLine);

    while(resultSet.next()){
        tmpLine = new ArrayList<String>();
        for(int i=1; i<=cols; ++i){
            tmpLine.add(resultSet.getString(i));
        }
        results.add(tmpLine);
    }
    return results;
}