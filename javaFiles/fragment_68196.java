protected SimpleJdbcCall buildJdbcCall(JdbcTemplate jdbcTemplate) {
    SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
            .withSchemaName(schema)
            .withCatalogName(catalog)
            .withFunctionName(functionName) 
            // can use withProcedureName(procedureName) for procedures 
            //.withReturnValue()
            //  .withoutProcedureColumnMetaDataAccess()  // may need this
            .declareParameters(buildSqlParameters());
    return call;
}

public SqlParameter[] buildSqlParameters() {
    return new SqlParameter[]{
        new SqlParameter("p_id", Types.VARCHAR),
        new SqlParameter("p_office_id", Types.VARCHAR),
        new SqlOutParameter("l_clob", Types.CLOB)
    };
}