Set<Thread> threads=ConcurrentHashMap.newKeySet();
List<Integer> samples=IntStream.range(0, 1_000_000).boxed().collect(Collectors.toList());
List<Integer> result=asSlowPagedSource(500_000, samples)
    .peek(x -> threads.add(Thread.currentThread()))
    .collect(Collectors.toList());
if(!samples.equals(result))
    throw new AssertionError();
System.out.println("Concurrency: "+threads.size());