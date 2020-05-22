public class CallableClass implements Callable<String> {
...
}

ExecutorService executor = new ScheduledThreadPoolExecutor(5);
Future<Integer> future = executor.submit(callable);

try {
    System.out.println(future.get());
} catch (Exception e) {
    // do something
}