jdbcTemplate.execute(
        new CallableStatementCreator() {
           public CallableStatement createCallableStatement(Connection con) throws SQLException{
              CallableStatement cs = con.prepareCall("{call sys.dbms_stats.gather_table_stats(ownname=>user, tabname=>'" + cachedMetadataTableName + "', estimate_percent=>20, method_opt=>'FOR ALL COLUMNS SIZE 1', degree=>0, granularity=>'AUTO', cascade=>TRUE, no_invalidate=>FALSE, force=>FALSE) }");
              return cs;
           }
        },
        new CallableStatementCallback() {
           public Object doInCallableStatement(CallableStatement cs) throws SQLException{
              cs.execute();
              return null; // Whatever is returned here is returned from the jdbcTemplate.execute method
           }
        }
  );