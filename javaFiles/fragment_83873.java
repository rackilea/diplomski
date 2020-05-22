private static final ThreadLocal<Map> CONTEXT = new ThreadLocal<Map>() {
        protected Map initialValue() {
            Map localMap = new HashMap();
            localMap.put(LocalContextKeys.CONVERSATION_CONTEXT, new HashMap());
            return localMap;
        };
    };

public static void putInLocalContext(Object key, Object value) {
    Map localMap = CONTEXT.get();
    localMap.put(key, value);
}

 public static Object getFromLocalContext(Object key) {
    Map localMap = CONTEXT.get();
    return localMap.get(key);
}