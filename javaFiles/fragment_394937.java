// Note: implements Iterable<E> now
public class MyHashTable<TKey, TValue> implements Iterable<MyHashTable.HashEntry<TKey, TValue>>
{
    public Iterator<MyHashTable.HashEntry<TKey, TValue>> iterator() {
        // ...
        // Make and return your iterator here
        // ...
    }

    // Note: public and generic now
    public static class HashEntry<TKey, TValue>
    {
        private TKey m_key;
        private TValue m_value;
        private EntryStatus status;

        //standard constructor
        // Note: private now
        public HashEntry(TKey key, TValue value)
        {
            m_key = key;
            m_value = value;
            status = EntryStatus.ACTIVE;
        }

        // Note: private now
        private HashEntry(TKey key, TValue value, EntryStatus i) {
            m_key = key;
            m_value = value;
            status = i;
        }

        //default 'empty' constructor
        // Note: private now
        public HashEntry()
        {
            //calls default constructor, creates placeholder entry
            m_key = null;
            m_value = null;
            status = EntryStatus.EMPTY;
        }

        public TKey getKey() {
            return m_key;
        }

        public TValue getValue() {
            return m_value;
        }

        public EntryStatus getEntryStatus() {
            return status;
        }

        //equals operator override, this override just compares compares
        // the objects held in the entry, so any object used with this
        // implementation must hae=ve its own equals override
        @Override
        public boolean equals(Object obj)
        {
            if (obj == null) { return false; }
            if (getClass() != obj.getClass()) { return false; }

            final HashEntry other = (HashEntry) obj;
            return (!((this.m_key == null) ? (other.m_key != null) : !this.m_key.equals(other.m_key)));
        }

        // override of the hashCode() function--just calls the hashCode
        // function of the embedded object, so that must be provided
        @Override
        public int hashCode()
        {
            return this.m_key.hashCode();
        }

        // toString override just returns the toString of the embedded object
        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(m_key.toString()).append(m_value.toString());
            return sb.toString();
        }
    }
}