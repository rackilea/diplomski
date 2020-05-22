void logProgress(Map<String, Future<?>> futures) {
  Future<String> future = ...
  futures.put("", future);  // Compiler error, but let's pretend it's OK.
}

Map<String, Future<Cache<?>> map = new HashMap<>();
logProgress(map);  // Compiler error, but let's pretend it's OK.
Future<Cache<?>> future = map.values().iterator().next();
Cache<?> cache = future.get();  // ClassCastException here!