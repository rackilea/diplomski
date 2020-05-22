import java.util.UUID;
import java.util.concurrent.*;

public class Test {

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<MyAnswer> someLongAsyncOperation(){

        Future<MyAnswer> future = executorService.submit(() -> {
            Thread.sleep(3000);
            return new MyAnswer(UUID.randomUUID().toString());
        });

        return future;
    }


    public static void main(String[] args) throws Exception {

        System.out.println("calling someLongAsyncOperation ...");
        Future<MyAnswer> future = new Test().someLongAsyncOperation();
        System.out.println("calling someLongAsyncOperation done.");

        // do something else

        System.out.println("wait for answer ...");
        MyAnswer myAnswer = future.get();
        System.out.printf("wait for answer done. Answer is: %s", myAnswer.value);

        executorService.shutdown();
    }

    static class MyAnswer {
        final String value;

        MyAnswer(String value) {
            this.value = value;
        }
    }
  }