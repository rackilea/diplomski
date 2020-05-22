....

if (sql.length() > 0) {
    String query = sql.toString().replaceAll("\\n", " ");
    query = query.replaceAll("\\t", " ");
    log.info(query);
    try {
        JdbcTemplate tmp = new JdbcTemplate(dataSource);
        tmp.execute(query);
    } catch (Exception e) {
        log.error(e.getMessage());
    }
}
...