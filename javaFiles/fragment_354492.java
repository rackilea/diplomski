@Configuration
public class DataConfig {
  @Bean
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .driverClassName("com.mysql.jdbc.Driver")
        .username("rdssample")
        .password("rdssample")
        .url("jdbc:mysql://rdssample.xxxxxx.us-west-2.rds.amazonaws.com:3306/customer")
        .build();
  }
}