public class MultitenantDataSourceResolver extends AbstractRoutingDataSource {
    @Autowired
    private Provider<CustomerWrapper> customerWrapper;

    private static final Map<String, DataSource> dsCache = new HashMap<String, DataSource>();

    @Override
    protected Object determineCurrentLookupKey() {
        try {
            return customerWrapper.get().getCustomerCode();

        } catch (Exception ex) {
            return null;

        }
    }

    @Override
    protected DataSource determineTargetDataSource() {
        String customerCode = (String) this.determineCurrentLookupKey();

        if (customerCode == null)
            return MultitenantDataSourceResolver.getDefaultDataSource();
        else {
            DataSource dataSource = dsCache.get(customerCode);
            if (dataSource == null)
                dataSource = this.buildDataSourceForCustomer();

            return dataSource;
        }
    }

    private synchronized DataSource buildDataSourceForCustomer() {
        CustomerWrapper wrapper = customerWrapper.get();

        if (dsCache.containsKey(wrapper.getCustomerCode()))
            return dsCache.get(wrapper.getCustomerCode() );
        else {
            DataSource dataSource = DataSourceBuilder.create(MultitenantDataSourceResolver.class.getClassLoader())
                    .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                    .url(wrapper.getJdbcUrl())
                    .username(wrapper.getDbUsername())
                    .password(wrapper.getDbPassword())
                    .build();

            dsCache.put(wrapper.getCustomerCode(), dataSource);

            return dataSource;
        }
    }

    private static DataSource getDefaultDataSource() {
        return DataSourceBuilder.create(CustomerDatabaseConfiguration.class.getClassLoader())
                .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
                .url("jdbc:sqlserver://localhost;databaseName=central")
                .username("sa")
                .password("mhsatuck")
                .build();
    }
}