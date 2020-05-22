@Configuration
@ConfigurationProperties(prefix = "jdbc")
@RequiredArgsConstructor // Lombok
public class DataSourceBeanFactory {

  // The DataSourceConfiguration holds everything from one property object
  @Setter // Lombok
  private List<DataSourceConfiguration> dataSources;
  private final ConfigurableApplicationContext applicationContext;

  @PostConstruct
  public void resolveAndCreateDataSourceBeans() {
    dataSources.forEach(dataSourceFromYaml -> {
      /*
       * Code to resolve driver class name
       */
      String driverClassName = ....

      DataSource dataSourceBean = DataSourceBuilder.create()
          .driverClassName(driverClassName)
          .url(dataSourceFromYaml.getJdbcUrl())
          .username(dataSourceFromYaml.getUsername())
          .password(dataSourceFromYaml.getPassword())
          .build();

      applicationContext
          .getBeanFactory()
          .registerSingleton(dataSourceFromYaml.getName(), dataSourceBean);
    });
  }