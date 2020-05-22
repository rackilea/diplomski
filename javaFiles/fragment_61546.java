@Component
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Autowired
    private DatabaseMap databaseMap;

    @Override
    public void afterPropertiesSet() {
        setTargetDataSources(databaseMap.getSourcesMap());
        setDefaultTargetDataSource(databaseMap.getSourcesMap().get("DEFAULT"));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.getDatabaseType();
    }

}

@Configuration
public class DatabaseLoader {
    @Bean
    public DatabaseMap databaseMap() {
    //init databases using DataSourceBuilder
    return databaseMap;
    }
}