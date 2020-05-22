private static final Map<Integer, String> myMap;
    static {
        Map<Integer, String> aMap = ....;
        aMap.put(1, "one");
        aMap.put(2, "two");
        myMap = Collections.unmodifiableMap(aMap);
    }