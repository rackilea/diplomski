public List<Map<String, Object>> showTables() {

    String sql = "select name from MYTABLE..sysobjects where xtype = 'U';";

    JdbcTemplate select = new JdbcTemplate(sqlDataSource);

    return select.queryForList(sql);
}