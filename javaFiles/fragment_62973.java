@Service
public class IntegrationLogService {

    private final IntegrationLogRepository logRepository;

    @Autowired
    public IntegrationLogService(IntegrationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Log log) {
        this.logRepository.save(log);
    }
}