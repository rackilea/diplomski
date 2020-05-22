try {
    Map < String, String > map = new HashMap < String, String > ();
    map.put(Environment.HBM2DDL_AUTO, "update");
    map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
    map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
    map.put(Environment.URL, "jdbc:mysql://localhost:3306/" + databaseName);
    map.put(Environment.USER, "root");
    map.put(Environment.PASS, "root");
    map.put(Environment.SHOW_SQL, "false");
    StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
        .applySettings(map)
        .build();
    try {
        MetadataSources metaDataSource = new MetadataSources(ssr);
        Set < Class << ? extends Object >> classes = getClassInPackage("com.domain");
        for (Class << ? extends Object > c : classes) {
            metaDataSource.addAnnotatedClass(c);
        }
        final MetadataImplementor metadata = (MetadataImplementor) metaDataSource
                                                                    .buildMetadata();
        metadata.validate();
        SchemaUpdate su = new SchemaUpdate(ssr, metadata);
        su.setHaltOnError(true);
        su.setDelimiter(";");
        su.setFormat(true);
        su.execute(true, true);
    } finally {
        StandardServiceRegistryBuilder.destroy(ssr);
    }
} catch (GenericJDBCException e) {
    e.printStackTrace();
}