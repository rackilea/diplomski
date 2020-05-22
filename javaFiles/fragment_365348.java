ResultSetHandler<List<java.sql.Date>> h = new ResultSetHandler<List<java.sql.Date>>() {

public List<java.sql.Date> handle(ResultSet rs) throws SQLException {
  List<java.sql.Date> result = new ArrayList<java.sql.Date>();
  while (rs.next()) {
     result.add(rs.getDate(1));
  }
  return result;
}
};

List<java.sql.Date> sqlDates = db.query(sql, h,new java.sql.Date(from.getTime()),new java.sql.Date(to.getTime()));