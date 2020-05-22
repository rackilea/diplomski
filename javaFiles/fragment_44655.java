314  public V get(Object key) {
315      if (key == null)
316          return getForNullKey();
317      int hash = hash(key.hashCode());
318      for (Entry<K,V> e = table[indexFor(hash, table.length)];
319           e != null;
320           e = e.next) {
321          Object k;
322          if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
323              return e.value;
324      }
325      return null;
326  }