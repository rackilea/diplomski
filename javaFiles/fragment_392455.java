/**
 * convert the cache full of items to regular HashMap with the same
 * key and value pair
 *
 * @return
 */
public Map<Product, Integer> convertToMap() {

    synchronized (lruMap) {

        Map<Product, Integer> convertedMap = new HashMap<>();

        MapIterator iterator = lruMap.mapIterator();

        K k = null;
        V v = null;

        CacheObject o = null;

        while (iterator.hasNext()) {

            k = (K) iterator.next();
            v = (V) iterator.getValue();

            Product product = (Product) k;

            o = (CacheObject) v;
            int itemsSold = Integer.valueOf((o.value).toString());

            convertedMap.put(product, itemsSold);
        }

        return convertedMap;
    }
}