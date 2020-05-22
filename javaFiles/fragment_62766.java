final AtomicLong counter = new AtomicLong();
final Map<String, Long> idMap = new LinkedHashMap<>();

public long idFor(String s) {
    return idMap.computeIfAbsent(s, isMap::incrementAndGet);
}