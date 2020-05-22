public class MyKeyStore<K extends hasName, V>
    extends HashMap<K,V>
    implements KeyValueStore<K,V>
{
    private PropertyChangeSupport changer = new PropertyChangeSupport(this);

    public void put(K key, V value)
    {
        V old = get(K);
        super.put(key,value);
        changer.firePropertyChange(key.getName(), value, old);
    }
}