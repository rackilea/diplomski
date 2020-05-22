@RefreshScope
public class DBPropRefresh {
  @Value("${dburl}")
  private String dbUrl;

  @Value("${dbusername}")
  private String dbUserName;

  @Value("${dbpassword}")
  private String dbPassword;

  @Bean
  @RefreshScope
  public DataSource getDatasource() {
    return new DatasourceBuilder().create().url(dbUrl).username(dbUserName).password(dbPassword);
  }
}