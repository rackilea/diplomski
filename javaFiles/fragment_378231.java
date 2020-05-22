HashMap<Integer,String> map = new HashMap<>(4, 1f);
map.put(0, "foo");
map.put(1, "bar");
map.put(2, "baz");
map.put(3, null);

map.values().parallelStream()
   .filter(Objects::nonNull)
   .forEach(v -> {
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(200));
    System.out.println(v+"\t"+Thread.currentThread());
});