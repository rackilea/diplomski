@Component
public class ColumnFetcher {
    @Cachable("columnNames")
    public List<String> fetchColNames (String tableName) {
        String query = "SELECT Upper(column_name) FROM information_schema.columns WHERE table_name = ?";
            List<String> cols = getJdbcTemplate().query(query, new Object[] {tableName}, new RowMapper<String>() {
               public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                   return rs.getString(1);
               } 
            });
        return cols;
    } 
}