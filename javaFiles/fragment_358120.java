// Create the test database with the LiquiBase migrations.
@BeforeClass
public static void up() throws Exception
{
    ManagedDataSource ds = RULE.getConfiguration().getMainDataSource().build(
        RULE.getEnvironment().metrics(), "migrations");
    try (Connection connection = ds.getConnection())
    {
        Liquibase migrator = new Liquibase("migrations.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(connection));
        migrator.update("");
    }
}