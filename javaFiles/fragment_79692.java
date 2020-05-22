NamedParameterJdbcTemplate template; //= new NamedParameterJdbcTemplate(pDs);
String INSERT_STMT = "INSERT INTO MYTABLE (ID, LONG_TEXT) VALUES (:id, :clob)";
MapSqlParameterSource paramSource = new MapSqlParameterSource();
paramSource.addValue("id", 1L, Types.NUMERIC);
paramSource.addValue("clob", "a long long text", Types.CLOB);
template.update(INSERT_STMT, paramSource);