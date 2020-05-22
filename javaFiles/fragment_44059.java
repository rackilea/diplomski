// You can see by the use of AtomicInteger that this isn't the right road to take!
final AtomicInteger i = new AtomicInteger();
final Collection<List<String>> values1 =
        mapOne.values()
              .stream()
              .flatMap(v -> v.stream())
              .collect(partitioningBy(o -> i.getAndIncrement() % 2 != 0))
              .values();