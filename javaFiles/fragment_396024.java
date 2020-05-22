@Component
public class CacheManager {

    private long second = 1000L;
    private long minute = second * 60;
    private long hour = minute * 60;

    private long TTL = hour;

    @Autowired
    private FraudCacheListRepository fraudCacheListRepository;


    @PostConstruct
    public void getAllTables(){
        List<FraudCacheListEntity> fraudCacheListEntities = fraudCacheListRepository.findAll();
        for (FraudCacheListEntity entity:fraudCacheListEntities) {
            System.out.println(entity.toString());
        }
    }
}