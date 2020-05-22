public class MyMap<K> extends TreeMap<K, Integer> {
        @Override
        public Integer put(K key, Integer value) throws ClassCastException, NullPointerException {
            java.lang.Integer newValue = java.lang.Integer.valueOf(123);
            super.put(key, newValue); 
            return newValue;
        }
    }