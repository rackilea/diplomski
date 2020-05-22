@ContextConfiguration(locations = { "/testContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class MyTest extends AbstractTransactionalJUnit4SpringContextTests{

    @PersistenceContext(unitName = "someUnit")
    private EntityManager entityManager;

    @Autowired
    private BeforeService beforeService;

    @Test
    public void test() {
        beforeService.before();
        // here some legacy Code is called that uses JDBC Templates to query 
        // the inserted test data. The legacy code hangs upon jdbcTemplate.query(...)
    }

}