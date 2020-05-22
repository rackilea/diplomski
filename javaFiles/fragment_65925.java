public class Cfg {
    private static Logger log = LoggerFactory.getLogger(Cfg.class);
    private Configuration cfg;
    private LoadingCache<String, Boolean> boolCache;
    private LoadingCache<String, String> stringCache;
    private LoadingCache<String, Float> floatCache;
    private LoadingCache<String, Integer> integerCache;
    private LoadingCache<String, List> listCache;

    @PostConstruct
    public void init() {
        boolCache = CacheBuilder.newBuilder().expireAfterAccess(cfg.getInt("configuration.cache"), TimeUnit.MINUTES).build(new CacheLoader<String, Boolean>() {
            @Override
            public Boolean load(String key) throws Exception {
                return check(cfg.getBoolean(key), key);
            }
        });
        stringCache = CacheBuilder.newBuilder().expireAfterAccess(cfg.getInt("configuration.cache"), TimeUnit.MINUTES).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return check(cfg.getString(key), key);
            }
        });
        floatCache = CacheBuilder.newBuilder().expireAfterAccess(cfg.getInt("configuration.cache"), TimeUnit.MINUTES).build(new CacheLoader<String, Float>() {
            @Override
            public Float load(String key) throws Exception {
                return check(cfg.getFloat(key), key);
            }
        });
        integerCache = CacheBuilder.newBuilder().expireAfterAccess(cfg.getInt("configuration.cache"), TimeUnit.MINUTES).build(new CacheLoader<String, Integer>() {
            @Override
            public Integer load(String key) throws Exception {
                return check(cfg.getInt(key), key);
            }
        });
        listCache = CacheBuilder.newBuilder().expireAfterAccess(cfg.getInt("configuration.cache"), TimeUnit.MINUTES).build(new CacheLoader<String, List>() {
            @Override
            public List load(String key) throws Exception {
                return check(cfg.getList(key), key);
            }
        });
    }

    public boolean _bool(String key) {
        try {
            return boolCache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public float _float(String key) {
        try {
            return floatCache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public int _int(String key) {
        try {
            return integerCache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public String _string(String key) {
        try {
            return stringCache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> _list(String key) {
        try {
            //noinspection unchecked
            return listCache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    private <T> T check(T el, String key) {
        if (el != null) {
            return el;
        }
        throw new KeyNotFound(key);
    }
}