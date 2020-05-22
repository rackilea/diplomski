@Configuration
public class MyConfig {

  @Bean(initMethod="initMethod")
  public DbConfigLoader dbConfigLoader() {
    return new DbConfigLoader();
  }

}



public class DbConfigLoader {

    @Autowired
    private DbConfigRepository repository;

    private DbConfig dbConfig;

    @PostConstruct   // Optional if you dont want to add initMethod in Bean Defination
    public void initMethod(){

    // Logic for your dynamic Data load
        dbConfig = repository.findOne(1L);  
    }

    public DbConfig getDbConfig() {
        return dbConfig;
    }
}