Map<Character, AtomicInteger> map = new HashMap<>();
for (Character c : characters) {
    AtomicInteger val = map.get(c);
    if (val != null) {
        val.incrementAndGet();
    } else {
        map.put(c, new AtomicInteger(1));
    }
}