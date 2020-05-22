@Component
public class CustomRoutingDataSource extends AbstractRoutingDataSource{
    @Autowired
    DataSourceMap dataSources;
    @Override
    protected Object determineCurrentLookupKey() {
        //setDataSources(dataSources);
        afterPropertiesSet();
        System.out.println("test");
        if( SecurityContextHolder.getContext().getAuthentication()!=null) {
            HttpServletRequest request = ((ServletRequestAttributes)
                    RequestContextHolder.getRequestAttributes()).getRequest();
            return request.getSession().getId();
        }

        return "auth";
    }
    @Autowired
    public void setDataSources(DataSourceMap dataSources) {
        System.out.println("data adding");
        setTargetDataSources(dataSources.getDataSourceMap());
    }

}