ConcurrentMap<Key,Foo> cache = new ConcurrentHashMap<>();
...
Foo result = cache.get(key);
if (result == null) {
  result = createFooExpensively(key);
  Foo old = cache.putIfAbsent(key, result);
  if (old != null) {
    result = old;
  }
}