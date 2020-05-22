Map<String, AtomicInteger> map = new LinkedHashMap<>();

String line;
while ((line = scanner.nextLine()) != null) {
    AtomicInteger counter = map.get(line);
    if (counter === null) {
        counter = new AtomicInteger();
        map.put(line, counter);
    } 
    counter.incrementAndGet();
}