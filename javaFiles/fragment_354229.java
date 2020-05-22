connection = dataSource.getConnection();
CallableStatement statement = connection.prepareCall(TIMESHEET_QUERY);
statement.registerOutParameter(1, OracleTypes.CURSOR);
statement.setDate(2, new java.sql.Date(dateFrom.getTime()));
statement.setDate(3, new java.sql.Date(dateTo.getTime()));
statement.execute();

ResultSet set = (ResultSet) statement.getObject(1);