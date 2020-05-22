ConcurrentHashMap<String, Integer> valueMap = 
      new ConcurrentHashMap<>(16, .75f, expectedConcurrentThreadCount);

public Response addToKey(@NotNull String key, @NotNull Integer value) {
     if (value > MAX_LIMIT) {
        // probably should set value to MAX_LIMIT-1 before failing
        return OVERFLOW; 
     }
     boolean updated = false;
     do {
        Integer old = putIfAbsent(key, value);
        if (old == null) {
             // it was absent, and now it has been updated to value: ok
             updated = true;
        } else if (old + value > MAX_LIMIT) {
             // probably should set value to MAX_LIMIT-1 before failing
             return OVERFLOW;
        } else {
             updated = valueMap.replace(key, old, old+value);
        }
     } while (! updated);

     return OK;
}