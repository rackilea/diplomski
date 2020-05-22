public Import getImportById(long id) {
       return jdbcTemplate.queryForObject(
          "Select a, b FROM import WHERE id = ?",
          this.importRowMapper,
          id);
}


private RowMapper<Import> importRowMapper = new RowMapper<Import>() {    
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
      long id = resultSet.getInt("id");
      String a = resultSet.getString("a");
      String b = resultSet.getString("b");
      return new Customer(id, a, b);
    }