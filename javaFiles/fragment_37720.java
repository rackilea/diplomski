QueryRunner run = JDBCConnectionFactory.getQueryRunner(database);
Connection conn = run.getDataSource().getConnection();
CallableStatement cs = conn.prepareCall("{CALL procName()}");
ResultSet rs = cs.executeQuery();
JongoResultSetHandler handler = new JongoResultSetHandler(true);
return handler.handle(rs);