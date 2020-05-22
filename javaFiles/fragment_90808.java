public abstract class QtMap<K, V> extends ForwardingMap<K, V>
{
    private final ListMultimap<K, V> listMultimap = ArrayListMultimap.create();

    final Map<K, V> delegate = Maps.<K, Collection<V>, V> transformEntries(listMultimap.asMap(), new EntryTransformer<K, Collection<V>, V>()
    {

        @Override
        public V transformEntry(K key, Collection<V> value)
        {
            return Iterables.getLast(value, defaultValue(key));
        }

    });

    @Override
    protected Map<K, V> delegate()
    {
        return delegate;
    }

    @Override
    public V put(K key, V value)
    {
        listMultimap.put(key, value);
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map)
    {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet())
        {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public V get(Object key)
    {
        return listMultimap.containsKey(key) ? delegate.get(key) : defaultValue(key);
    }

    protected abstract V defaultValue(Object key);

}