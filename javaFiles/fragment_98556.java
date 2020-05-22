@Service
@Transactional
public class YourService {

    private final YourCrudRepository repo;
    private final JdbcTemplate jdbc;

    public YourService(YourCrudRepository repo, JdbcTemplate jdbc) {
        this.repo=repo;
        this.jdbc=jdbc;
    }

    // Your methods go down here
}