SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
        .withSchemaName("SCHMA").withCatalogName("PKG_USER")
        .withFunctionName("get_user_by_term");
Map<String, Object> inParamMap = new HashMap<String, Object>();
inParamMap.put("inUserTerm ", userTermId );
SqlParameterSource in = new MapSqlParameterSource(inParamMap);
Long userId = simpleJdbcCall.executeFunction(BigDecimal.class, in).longValue();