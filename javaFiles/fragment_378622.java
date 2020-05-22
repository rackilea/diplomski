Map<String, Metric> memoryMap = memory.getMetrics();

for (String key : memoryMap.keySet()) {
    Metric m = memoryMap.get(key);
    System.out.println(m.getClass());

    if (m instanceof Gauge) {
        System.out.println(((Gauge<Long>) m).getValue());
    }
}