spring.mysqldatasource.driver-class-name=com.mysql.jdbc.Driver
 spring.mysqldatasource.url=jdbc:mysql://localhost:3306/ccm_new
 spring.mysqldatasource.username=test
 spring.mysqldatasource.password=test
 spring.mysqldatasource.dbcp2.initial-size=5
 spring.mysqldatasource.dbcp2.max-total=15
 spring.mysqldatasource.dbcp2.pool-prepared-statements=true



spring.oracledatasource.url=jdbc:oracle:thin:@localhost:1521:mastera
spring.oracledatasource.password=test
spring.oracledatasource.username=test
spring.oracledatasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.oracledatasource.dbcp2.initial-size=5
spring.oracledatasource.dbcp2.max-total=15
spring.oracledatasource.dbcp2.pool-prepared-statements=true



 @Configuration
 public class PrototypeUtility {
 @Bean(name = "dsMaster")
@Primary
@ConfigurationProperties(prefix="spring.oracledatasource")
public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
}
@Bean(name = "jdbcMaster")
public JdbcTemplate masterJdbcTemplate(@Qualifier("dsMaster") DataSource dsMaster) {
      return new JdbcTemplate(dsMaster);
}

@Bean(name = "dsMasterMysql")
@ConfigurationProperties(prefix="spring.mysqldatasource")
public DataSource primaryDataSourceMysql() {
    return DataSourceBuilder.create().build();
}
@Bean(name = "jdbcMasterMysql")
public JdbcTemplate masterMysqlJdbcTemplate(@Qualifier("dsMasterMysql") DataSource dsMasterMysql) {
      return new JdbcTemplate(dsMasterMysql);
}
  }