public V put(K key, V value) {
387         if (key == null)
388             return putForNullKey(value);
389         int hash = hash(key.hashCode());
390         int i = indexFor(hash, table.length);
391         for (Entry<K,V> e = table[i]; e != null; e = e.next) {
392             Object k;
393             if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
394                 V oldValue = e.value;
395                 e.value = value;
396                 e.recordAccess(this);
397                 return oldValue;
398             }
399         }
400 
401         modCount++;
402         addEntry(hash, key, value, i);
403         return null;
404     }