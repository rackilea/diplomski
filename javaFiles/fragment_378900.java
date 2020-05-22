final String insertNewFieldSql = Config.getSqlProperty("insert_new_field_record");      
    GeneratedKeyHolder holder = new GeneratedKeyHolder();
    MapSqlParameterSource parameters = null;

    for (ParsedData field : fields) {

            parameters = new MapSqlParameterSource();
            parameters.addValue("FIELD_1",parsedEmail.getDbRecordId())
                    .addValue("FIELD_2",field.getName());

            namedParameterJdbcTemplate.update( insertNewFieldSql, parameters, holder, new String[] {"PK_FIELD_ID" } );

            Long newFieldKey = holder.getKey().longValue();
            logger.log(Level.FINEST, "row was added: " + newFieldKey);
            }