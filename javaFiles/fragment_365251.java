@Bean(name = "originJdbcTemplate")
public JdbcTemplate originJdbcTemplate() throws SQLException {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(originDataSource());
    jdbcTemplate.getDataSource().getConnection().setCatalog(defaultOriginSchema);
    return jdbcTemplate;
}