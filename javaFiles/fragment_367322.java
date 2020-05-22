// The component scanner will find this annotation and create 
// the bean (and inject the dependencies)
@Component
public class SomeDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired // enables constructor-injection
    public SomeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}