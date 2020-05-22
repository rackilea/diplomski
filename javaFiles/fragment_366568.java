private static final Map<String, Map<String, MyPrivateClass>> testParameters = new ConcurrentHashMap<>();

public static void put(String key, TreeMap<String, MyPrivateClass> value) {
    testParameters.compute(key, (k,v) -> {
            if(null == v) {
                v = Collections.synchronizedMap(new TreeMap<>(value.comparator()));
            }
            v.putAll(value);
            return v;
        }
    );
}