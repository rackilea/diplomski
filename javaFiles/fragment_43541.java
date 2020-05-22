@Bean
public class DataSourceHolder implements InitializingBean {
    private DataSource dataSource;

    private static DataSourceHolder instance;

    public static DataSource getDataSource() {
        return instance.dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        DataSourceHolder.instance = this;
    }
}