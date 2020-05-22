@Transactional(value = "transactionManager", rollbackFor = java.lang.Exception.class)
public BigInteger createObject(BigInteger object_id, String name) {
    simpleCallTemplate.withFunctionName(INSERT_OBJECT);
    SqlParameterSource in = new MapSqlParameterSource()
            .addValue("obj_type_id", object_id)
            .addValue("obj_name", name);
    return simpleCallTemplate.executeFunction(BigDecimal.class, in).toBigInteger();
}