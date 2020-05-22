@Repository
public class DBQuery {

    private final JdbcTemplate jdbcTemplate;

    @Autowired    
    public DBQuery(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Passport> getAllDataPassport() {

        String sql = "select * from testing_table";
        return this.jdbcTemplate.query(sql, new PassportRowMapper());
    }
}