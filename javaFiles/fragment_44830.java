public class CacheManager {

// No generic type information should be required.
private static final CacheManager singletonInstance = new CacheManager();
// This will allow a 'Cache' of any type to be registered.
private  Map<String, Cache> map = new HashMap<>();