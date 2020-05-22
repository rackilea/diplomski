@Singleton
public class MasterDataCache 
{
    private final static Logger logger = LoggerFactory.getLogger(MasterDataCache.class);

    private Map cache;

    @PostConstruct
    public void initCache() {
        logger.debug("initCache()");
        this.cache = new HashMap();
    }

    public Object get(String key){
        return this.cache.get(key);
    }

    public void store(String key,Object value){
        this.cache.put(key, value);
    }
}