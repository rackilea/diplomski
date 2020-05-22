private final HibernateBundle<MyConfiguration> hibernate =
        new ScanningHibernateBundle<MyConfiguration>("com.acme.entity") {

            @Override
            public DataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        };