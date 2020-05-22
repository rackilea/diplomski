HashMap<Integer,String> map = new HashMap<>();
map.put(0, "foo");
map.put(1, "bar");
map.put(2, "baz");

map.values().parallelStream().forEach(v -> {
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(200));
    System.out.println(v+"\t"+Thread.currentThread());
});