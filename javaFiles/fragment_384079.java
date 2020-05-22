@Configuration
  @Import({ DataSourceAConfig.class }) // Import additional configuration files as required
  public class MasterConfig {

          @Autowired DataSourceAConfig dataSourceAConfigContext; 

            @Bean public List<DataSource> getAllDataSources(){
                 DataSource dataSourceA = dataSourceAConfigContext.getDataSourceBean()
                 // Add data in sequentially way, one after the other 
                return Arrays.asList(dataSourceA);
     }
  }