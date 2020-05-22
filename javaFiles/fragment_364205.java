@Service
public class MeasurementRepository {
    @Autowired
    JdbcTemplate template;

    public List<Measurement> findAllMeasurementDataPoints() {
         template.query(your_query, (rs, rowNumber) -> {
              Measurement measurement = new Measurement();
              ... your mapping here ....
              return measurement;
         })
    }