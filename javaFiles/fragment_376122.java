Map result = simpleJdbcTemplate.queryForMap(
 "SELECT COUNT(*) AS intRecords " +
 "FROM tblUsers",
 new Object[]);

Integer users = result.get("intRecords");