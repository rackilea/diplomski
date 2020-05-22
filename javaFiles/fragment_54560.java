public class Main {
  public static void main(String... args) {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1000);

    new Thread(() -> {
      for (int i = 0; i < 1000; ++i) {
        try {
          queue.put(i);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }).start();


    Spliterator<Integer> queueSpliterator = new QueueSpliterator<>(queue);
    Stream<Integer> stream = StreamSupport.stream(queueSpliterator, false);

    stream.forEach(System.out::println);
  }
}