KeyHolder newCode = injectedKeyFactory.getKeyHolder();
try {
    namedParameterJdbcTemplate.update(sql, paramMap, newCode);
} catch (DuplicateKeyException e) {
    logger.error("Duplicate Key");
}
data.setId(newCode.getKey().intValue());