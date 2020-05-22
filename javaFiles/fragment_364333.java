public class HashTable<K, V>
{
    private LinkedList<V>[] m_storage;

    public HashTable(int initialSize)
    {
        m_storage = (LinkedList<V>[]) new LinkedList[initialSize];
    }
}