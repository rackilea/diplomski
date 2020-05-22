NamedParameterJdbcTemplate namedJdbcTemplate = new NamedParameterJdbcTemplate( jdbcTemplate.getDataSource() );

    Set<String> maps = new HashSet<String>();
    maps.add("long")
    maps.add("red")
    maps.add("wire")
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("tags", maps  );                
    namedJdbcTemplate.query( "SELECT ... tags  in (:tags)" , params , new RowMapper() {

        @Override
        public Object mapRow(ResultSet rs, int arg1) throws SQLException {
             ....
        }
    });