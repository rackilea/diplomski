import com.google.common.collect.ForwardingMap;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints;
import com.google.inject.Key;
import org.apache.commons.lang.NotImplementedException;

import java.util.HashMap;
import java.util.Map;


public final class MutableGuiceKeyToInstanceMap<B>
        extends ForwardingMap<Key<? extends B>, B> {

    /**
     * Returns a new {@code MutableGuiceKeyToInstanceMap} instance backed by a {@link
     * java.util.HashMap} using the default initial capacity and load factor.
     */
    public static <B> MutableGuiceKeyToInstanceMap<B> create() {
        return new MutableGuiceKeyToInstanceMap<B>(new HashMap<Key<? extends B>, B>());
    }

    /**
     * Returns a new {@code MutableGuiceKeyToInstanceMap} instance backed by a given
     * empty {@code backingMap}. The caller surrenders control of the backing map,
     * and thus should not allow any direct references to it to remain accessible.
     */
    public static <B> MutableGuiceKeyToInstanceMap<B> create(Map<Key<? extends B>, B> backingMap) {
        return new MutableGuiceKeyToInstanceMap<B>(backingMap);
    }


    private final Map<Key<? extends B>, B> delegate;

    private MutableGuiceKeyToInstanceMap(Map<Key<? extends B>, B> delegate) {
        this.delegate = MapConstraints.constrainedMap(delegate, VALUE_MATCHES_GUICE_KEY);
    }

    @Override
    protected Map<Key<? extends B>, B> delegate() {
        return delegate;
    }

    private static final MapConstraint<Key<?>, Object> VALUE_MATCHES_GUICE_KEY = new MapConstraint<Key<?>, Object>() {
        @Override
        public void checkKeyValue(Key<?> key, Object value) {
            matchesGuiceKey(key, value);
        }
    };

    public <T extends B> T putInstance(Key<T> key, T value) {
        return matchesGuiceKey(key, put(key, value));
    }

    public <T extends B> T getInstance(Key<T> key) {
        return matchesGuiceKey(key, get(key));
    }

    private static <B, T extends B> T matchesGuiceKey(Key<T> key, B value) {
        throw new NotImplementedException("TODO");
    }

    private static final long serialVersionUID = 0;
}