final String sql = "CREATE PROCEDURE `app_configs_select_all`()\n" +
                   "BEGIN\n" +
                   "    select config_id,\n" +
                   "        config_name,\n" +
                   "        config_value,\n" +
                   "        config_type,\n" +
                   "        description,\n" +
                   "        client_id\n" +
                   "    from app_configs;\n" +
                   "END";


try (final Connection conn = creationDataSource.getConnection()) {
    conn.createStatement().execute(sql);
} catch (SQLException e) {
    e.printStackTrace();
}