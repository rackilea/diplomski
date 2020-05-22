DataSource dataSource = getDataSourceFromSomewhere();
DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource);
JdbcTemplate jdbc = new JdbcTemplate(dataSource);
TransactionStatus tx = tm.getTransaction(new DefaultTransactionDefinition());

int update1 = jdbc.update("insert into employee...");
int employeeId = jdbc.queryForInt(select id from employee...");
int update2 = jdbc.update("insert into employee_department...");

if (employeeId > 0 && update2 > 0) 
    tm.commit(tx);
else
    tm.rollback(tx);