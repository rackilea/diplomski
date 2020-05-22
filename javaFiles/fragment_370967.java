409     private V putForNullKey(V value) {
410         for (Entry<K,V> e = table[0]; e != null; e = e.next) {
411             if (e.key == null) {
412                 V oldValue = e.value;
413                 e.value = value;
414                 e.recordAccess(this);
415                 return oldValue;
416             }
417         }
418         modCount++;
419         addEntry(0, null, value, 0);
420         return null;
421     }