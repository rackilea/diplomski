private DataSource init() {

    DataSource unpooled = DataSources.unpooledDataSource(DB_URL, DB_USERNAME, DB_PASSWORD);

    Map<String, Object> overrideProps = new HashMap<String, Object>();

    overrideProps.put("maxPoolSize", MAX_POOL_SIZE);
    overrideProps.put("minPoolSize", MIN_POOL_SIZE);

    return DataSources.pooledDataSource(unpooled, overrideProps);
}