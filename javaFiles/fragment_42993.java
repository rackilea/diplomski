@Override
public synchronized void beforeTestClass(TestContext testContext) {
    ...
    // import the table definitions from a previously dumped file
    ResourceDatabasePopulator populator = new OrderedResourceDatabasePopulator();
    populator.addScript(new ClassPathResource("some-table-definitions.sql"));
    populator.execute(dataSource);
    ...
}