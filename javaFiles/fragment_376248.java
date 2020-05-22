public class ExecutorTest {
private static List<String> result = new ArrayList<>();

public static void main(String[] args) throws Exception {
    ExecutorService ex = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
        Callable worker = new Worker(i);

        Future<String> stringResult= ex.submit(worker);
        String output = stringResult.get();
        result.add(output);
        System.out.println(output);

    }
    ex.shutdown();
    while (!ex.isTerminated());
    System.out.println("All results received frmo executor service ");
    System.out.println(result);
}


}