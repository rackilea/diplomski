@Transactional(readOnly=true)
 public List<myTable_Model> getAll(String id) {
   List<myTable_Model> result = new ArrayList<>();
   try {
       String sql = "SELECT * from myTable order by last_modified desc";
       result = jdbcTemplate.query(sql, new Clone_HistoryRowMapper());
   }
   catch(SQLException ex) {
      logger.log("An error happened when interacting to the database.", ex)
   }
   return result;
 }