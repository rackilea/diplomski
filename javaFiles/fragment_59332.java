NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

 MapSqlParameterSource paramSource = new MapSqlParameterSource();
 paramSource.addValue("name", name);
 paramSource.addValue("city", city);
 jdbcTemplate.queryForRowSet("SELECT * FROM customers WHERE name = :name AND city = :city", paramSource);