public static void Iterate(int[] values, int from, int to) {
  long start = System.nanoTime();
  final IntPredicate predicate = i -> i < to && i > from;
  System.out.println("Predicate lambda creation time:" + NANOSECONDS.toMillis(System.nanoTime() - start));
  start = System.nanoTime();
  final IntConsumer action = System.out::println;
  System.out.println("Action lambda creation time:" + NANOSECONDS.toMillis(System.nanoTime() - start));
  start = System.nanoTime();
  final IntStream stream = IntStream.of(values).filter(predicate);
  System.out.println("Stream creation time:" + NANOSECONDS.toMillis(System.nanoTime() - start));
  start = System.nanoTime();
  stream.forEach(action);
  System.out.println("Stream consumption time:" + NANOSECONDS.toMillis(System.nanoTime() - start));
}