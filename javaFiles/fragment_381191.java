long start = System.currentTimeMillis();
Map<Integer, Integer> freq = IntStream.range(0, 1000000000).parallel()
        .mapToObj(i -> i % 10)
        .collect(Collectors.groupingBy(w -> w, Collectors.summingInt(e -> 1)));
long time = System.currentTimeMillis() - start;
System.out.println("Took " + time+" ms " + freq);