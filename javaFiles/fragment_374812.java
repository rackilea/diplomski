@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class })
public class MyDaoTest extends DBTestCase {

@Autowired
private MyDao myDao;

/**
 * This is the underlying BasicDataSource used by Dao. If The Dao is using a
 * support class from Spring (i.e. HibernateDaoSupport) this is the
 * BasicDataSource that is used by Spring.
 */
@Autowired
private BasicDataSource dataSource;

/**
 * DBUnit specific object to provide configuration to to properly state the
 * underlying database
 */
private IDatabaseTester databaseTester;

/**
 * Prepare the test instance by handling the Spring annotations and updating
 * the database to the stale state.
 * 
 * @throws java.lang.Exception
 */
@Before
public void setUp() throws Exception {
    databaseTester = new DataSourceDatabaseTester(dataSource);
    databaseTester.setDataSet(this.getDataSet());
    databaseTester.setSetUpOperation(this.getSetUpOperation());
    databaseTester.onSetup();
}

/**
 * Perform any required database clean up after the test runs to ensure the
 * stale state has not been dirtied for the next test.
 * 
 * @throws java.lang.Exception
 */
@After
public void tearDown() throws Exception {
    databaseTester.setTearDownOperation(this.getTearDownOperation());
    databaseTester.onTearDown();
}

/**
 * Retrieve the DataSet to be used from Xml file. This Xml file should be
 * located on the classpath.
 */
@Override
protected IDataSet getDataSet() throws Exception {
    final FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
    builder.setColumnSensing(true);
    return builder.build(this.getClass().getClassLoader()
            .getResourceAsStream("data.xml"));
}

/**
 * On setUp() refresh the database updating the data to the data in the
 * stale state. Cannot currently use CLEAN_INSERT due to foreign key
 * constraints.
 */
@Override
protected DatabaseOperation getSetUpOperation() {
    return DatabaseOperation.CLEAN_INSERT;
}

/**
 * On tearDown() truncate the table bringing it back to the state it was in
 * before the tests started.
 */
@Override
protected DatabaseOperation getTearDownOperation() {
    return DatabaseOperation.TRUNCATE_TABLE;
}

/**
 * Overridden to disable the closing of the connection for every test.
 */
@Override
protected void closeConnection(IDatabaseConnection conn) {
    // Empty body on purpose.
}
// Continue TestClass here with test methods.