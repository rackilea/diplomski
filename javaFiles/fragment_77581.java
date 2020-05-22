public class Main {
    public static void main(String[] args) {
        final ExecutorService executorService;
        final Future<Integer> future;
        final int statusCode;

        executorService = Executors.newFixedThreadPool(1);
        future = executorService.submit(new TextMessagePrinter());

        try {
            statusCode = future.get();
            if (statusCode == 10) { // Printed successfully
                System.out.println("JOB DONE. EXITING...");
                Runtime.getRuntime().exit(0); // A zero status code indicates normal termination.
            } else {
                System.out.println("ERR...SOMETHING WEIRD HAPPENED!");
                Runtime.getRuntime().exit(statusCode);  // A non-zero status code indicates abnormal termination.
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();
        }
    }
}

class TextMessagePrinter implements Callable<Integer> {
    public Integer call() {
        Integer STATUS_CODE;
        try {
            System.out.println("Printing hello..."); // Try printing something
            System.out.println("Dividing 6 by 0 gives us: " + 6 / 0); // And then you try to do something knowing which will result in an exception
            STATUS_CODE = 10; // Indicates success.
        } catch (ArithmeticException e) {
            STATUS_CODE = 20; // Indicates failure...setting status code to 20.
        }
        return STATUS_CODE;
    }
}