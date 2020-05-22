private void setConnectionReadOnly(boolean readOnly) {
    log.debug("setting JDBC connection to {}", readOnly);
    try {
        Connection con = DataSourceUtils.getConnection(jdbcTemplate.getDataSource());
        con.setReadOnly(readOnly);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}