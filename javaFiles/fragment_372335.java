Map<String, Double> map = new LinkedHashMap<>();
map.put("first", 1.0);
map.put("second", 5.0);
map.put("third", 4.0);

AtomicReference<Double> atomicSum = new AtomicReference<>(0.0);
map.entrySet().forEach(e -> e.setValue(
    atomicSum.accumulateAndGet(e.getValue(), (x, y) -> x + y)
));

// tested in JUnit
assertEquals(10.0, atomicSum.get(), 0.0001);
assertEquals(1.0, map.get("first"), 0.0001);
assertEquals(6.0, map.get("second"), 0.0001);
assertEquals(10.0, map.get("third"), 0.0001);