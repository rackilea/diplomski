public String getStreetNameById(int id) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    String sql = "SELECT STREET_NAME FROM table WHERE ID=?";

    String streetName = (String) jdbcTemplate.queryForObject(
            sql, new Object[] { id }, String.class);

    return streetName;
}