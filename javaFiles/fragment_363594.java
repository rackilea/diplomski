@Override   
public Set<Map.Entry<K, V>> entrySet(){  
  if (entrySetView != null) 
    return entrySetView;
  else 
    return entrySetView = new AbstractSet<Map.Entry<K, V>>() {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new HashIterator<Map.Entry<K, V>>() {
                @Override
                public Map.Entry<K, V> next() {
                    return nextEntry();
                }
            };
        }

        @Override
        public int size() {
            return HashMap.this.size();
        }

        @Override
        public void clear() {
            HashMap.this.clear();
        }
    };
}