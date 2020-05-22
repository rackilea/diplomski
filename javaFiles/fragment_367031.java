import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ThreeLevelMap<K1, K2, K3, V> {
    private Map<K1, Map<K2, Multimap<K3, V>>> firstLevelMap = new HashMap<>();
    private Map<Pair<K1, K2>, Multimap<K3, V>> secondLevelMap = new HashMap<>();
    private Multimap<Triple<K1, K2, K3>, V> thirdLevelMap = HashMultimap.create();

    public void put(K1 key1, K2 key2, K3 key3, V value) {
        thirdLevelMap.put(Triple.of(key1, key2, key3), value);

        final Pair<K1, K2> secondLevelKey = Pair.of(key1, key2);
        Multimap<K3, V> secondLevelContainer = secondLevelMap.get(secondLevelKey);
        if (secondLevelContainer == null) {
            secondLevelContainer = HashMultimap.create();
            secondLevelMap.put(secondLevelKey, secondLevelContainer);
        }
        secondLevelContainer.put(key3, value);

        Map<K2, Multimap<K3, V>> firstLevelContainer = firstLevelMap.get(key1);
        if (firstLevelContainer == null) {
            firstLevelContainer = new HashMap<>();
            firstLevelMap.put(key1, firstLevelContainer);
        }
        firstLevelContainer.put(key2, secondLevelContainer);
    }

    public Collection<V> get(K1 key1, K2 key2, K3 key3) {
        return thirdLevelMap.get(Triple.of(key1, key2, key3));
    }

    public Multimap<K3, V> get(K1 key1, K2 key2) {
        return secondLevelMap.get(Pair.of(key1, key2));
    }

    public Map<K2, Multimap<K3, V>> get(K1 key1) {
        return firstLevelMap.get(key1);
    }
}