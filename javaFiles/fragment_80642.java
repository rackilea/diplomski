import java.util.*;

class CacheMap<K,V> extends LinkedHashMap<K,V> {
    protected final int maxCapacity;
    public CacheMap(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxCapacity;
    }
}