@Repository
public class DatabaseDAO {
    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    public List<String> getAllRecords() {
        return jdbcTemplate.queryForObject("select record from my_table", List.class);
    }
}