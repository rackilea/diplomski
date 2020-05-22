package org.springframework.jdbc.core;

public class JdbcTemplate extends JdbcAccessor implements JdbcOperations {

     //...
    public <T> T queryForObject(String sql, Object[] args, 
        RowMapper<T> rowMapper) throws DataAccessException {
    List<T> results = query(sql, args, new RowMapperResultSetExtractor<T>(rowMapper, 1));
    return DataAccessUtils.requiredSingleResult(results);
    }