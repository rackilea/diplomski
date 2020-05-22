@Service
public class JobService {

    private static final String FIND_EXECUTIONS = "SELECT JOB_EXECUTION_ID FROM batch_job_execution_params WHERE KEY_NAME = 'user' AND STRING_VAL = ? ORDER BY JOB_EXECUTION_ID DESC";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Long> findJobExecutionIdsByUser(String username) {
        return jdbcTemplate.queryForList(FIND_EXECUTIONS, Long.class, username);
    }

}