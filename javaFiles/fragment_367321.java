public class SomeDAO {
    private final JdbcTemplate jdbcTemplate;

    public SomeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}