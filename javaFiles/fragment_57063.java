import java.util.Collection;
import java.util.Set;

public interface NKeyMap<K, V> {
public void clear();
public boolean containsKey(K... k );
public boolean containsValue(V value);
public V get(K... k);
public boolean isEmpty();
public V put(V value, K...k);
public V remove(V value, K... k);
public int size();
public Collection<V> values();
public Set<K> keys();
}