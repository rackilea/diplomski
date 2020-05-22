// need more buckets
        LinkedList<KVP<K, V>> oldBuckets = buckets;
        buckets = (LinkedList<KVP<K, V>>[]) new LinkedList[buckets.length* 2];

        //Making it so they aren't all Null
        for(int i = 0; i < buckets.length; i++)
        {
            buckets[i] = new LinkedList<KVP<K, V>>();
        }

        // we know there are no duplicates so we can put things back in easily
        for (int i = 0; i < oldBuckets.length; i++) {
            for (KVP<K, V> entry : oldBuckets[i]) {
               buckets[bucket(entry.getKey())].add(entry);
            }
        }