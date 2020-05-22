SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(spaeJDBCTemplate).withCatalogName("SCHEMA1").withProcedureName("PROCESS");
    Map<String, Integer> inParamMap = new HashMap<String, Integer>();
    inParamMap.put("process", 0);
    SqlParameterSource in = new MapSqlParameterSource(inParamMap);
    try{
        simpleJdbcCall.execute(in);
    }catch(Exception e){
        log.error("Error ", e);
    }