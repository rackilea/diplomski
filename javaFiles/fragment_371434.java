import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Object receivedObject;
    private final Object mutex = new Object();

    public static void main (String[] args) throws InterruptedException {
        Object obj = new Test2().someMethod();

        System.out.println("The object is" + obj + ", wooh!");

        executorService.shutdown();
    }

    public void callObject() {

        System.out.println("callObject ...");

        // Sends request for the object asynchronously!
        executorService.submit(() -> {

            // some wait time to simulate slow request
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // provide object to callback
            receiveObject(UUID.randomUUID().toString());
        });

        System.out.println("callObject done.");
    }

    public void receiveObject(Object object) {

        System.out.println("receiveObject ...");

        synchronized (mutex) {
            this.receivedObject = object;
            mutex.notify();
        }

        System.out.println("receiveObject done.");
    }

    public Object someMethod() throws InterruptedException {

        System.out.println("someMethod ...");

        synchronized (mutex) {
            callObject();
            while(this.receivedObject == null){
                mutex.wait();
            }
        }

        System.out.println("someMethod done.");
        return this.receivedObject;
    }

}