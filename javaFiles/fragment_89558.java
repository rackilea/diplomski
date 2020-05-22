public static void ExecuteStoredProc(String procedureName, Map<String, String> parameters)
{
    JdbcTemplate template = new JdbcTemplate(SpringJDBCConfig.sqlDataSource());

    MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();

    for (String key : parameters.keySet()) {
        sqlParameterSource.addValue(key, parameters.get(key));
    }

    SimpleJdbcCall call = new SimpleJdbcCall(template)
            .withCatalogName("matrix")
            .withSchemaName("dbo")
            .withProcedureName(procedureName);

   call.execute(sqlParameterSource);
}