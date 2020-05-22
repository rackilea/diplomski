private final HibernateBundle<ApiConfig> hibernatePlayerBundle =
    new ScanningHibernateBundle<ApiConfig>("core") {
        @Override
        public DataSourceFactory getDataSourceFactory(ApiConfig configuration) {
            return configuration.getDataSourceFactory();
        }
};