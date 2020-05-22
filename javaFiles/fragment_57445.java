public class MyMap<K, Integer extends java.lang.Integer> extends TreeMap<K, Integer> {
        @Override
        public Integer put(K key, Integer value) throws ClassCastException, NullPointerException {
            Integer newValue = (Integer) java.lang.Integer.valueOf(123);
            super.put(key, newValue); 
            return newValue;
        }
    }