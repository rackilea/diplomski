import javax.cache.Cache;

public class CacheHelper {
    public static final void update(Cache cache,String key,Object value) {
        cache.put(key,value);
    }
}