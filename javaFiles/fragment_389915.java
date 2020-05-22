@Slf4j
//@SpringBootTest
@SpringBatchTest
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ContextConfiguration(classes = {
        PaySalaryJobConfiguration.class
})
@ActiveProfiles("test")
public class StepScopeIntegrationTest {

    @Autowired
    private JpaPagingItemReader<Employee> someoneReader;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private StepExecution stepExecution;

    @Before
    public void setUp() {
        log.info("Before execution we have {} entries", jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class ));
    }

    public StepExecution getStepExecution() {
        log.info("Step Execution !");
        stepExecution = MetaDataInstanceFactory.createStepExecution();
        log.info("Context = {} / Step = {} ", stepExecution.getExecutionContext(), stepExecution.getStepName());
        return stepExecution;
    }

    @Test
    public void testReader() throws Exception {
        log.info("Page = {}", someoneReader.getPage());
        log.info("PageSize = {}", someoneReader.getPageSize());
        someoneReader.open(stepExecution.getExecutionContext());
        Assert.assertNotNull(someoneReader.read());
    }
}