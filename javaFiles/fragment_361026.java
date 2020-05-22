int equal = 0;
for(int i=0; i<100; i++) {
    // create test input map like {0 -> 0, 1 -> 1, 2 -> 2, ...}
    Map<Integer, Integer> input = IntStream.range(0, 200).boxed()
         .collect(Collectors.toMap(x -> x, x -> x));
    Map<Integer, Integer> result = new HashMap<>();
    // write it into another HashMap in parallel way without key collisions
    input.entrySet().parallelStream().unordered()
         .forEach(entry -> result.put(entry.getKey(), entry.getValue()));
    if(result.equals(input)) equal++;
}
System.out.println(equal);