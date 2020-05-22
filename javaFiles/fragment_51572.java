@Component
@Scope(value = "singleton")
public class DataSourceMap {
    private Map<Object,Object> dataSourceMap;
    public DataSourceMap()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:AZ;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        dataSourceMap=new HashMap<Object,Object>();
        dataSourceMap.put("auth",dataSourceBuilder.build());
    }
    public void addDataSource(String session,DataSource dataSource)
    {
        this.dataSourceMap.put(session,dataSource);
    }
    public Map<Object,Object> getDataSourceMap()
    {
        return dataSourceMap;
    }
    public void removeSource(String session)
    {
        dataSourceMap.remove(session);
    }
}