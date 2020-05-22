private final AtomicReference<ImmutableMap<String, Object>> resourceMap;

public void write(String key, Object value) {
    boolean success = false;
    while(!success) {
        ImmutableMap oldMap = resourceMap;
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.putAll(resourceMap.entrySet());
        builder.put(key, value);
        success = resourceMap.compareAndSet(oldMap, builder.build());
    }
}

public Object read(String var1) {
    ...
    return resourceMap.get().get(var1); // get map, then get value
}
public Object read(String var1, String var2);
public Object read(String var1, String var2, String var3);