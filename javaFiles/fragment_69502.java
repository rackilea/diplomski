List<EmployeeDto> deals = jdbcTemplate.query(
    sql,
    new Object[] {empId},
    new RowMapper<EmployeeDto>() {
      public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDto d = new EmployeeDto();
        d.setName(rs.getString(2));
        return d;
      }
});