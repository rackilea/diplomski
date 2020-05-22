import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FastestOf3 {

    public static void main(String[] args) throws Exception {
        System.out.println(search("foo"));
    }

    static Object search(String key) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        final Object[] answer = new Object[1];
        Future f1 = es.submit(() -> searchEmulation(answer, 1000, "1"));
        Future f2 = es.submit(() -> searchEmulation(answer, 200, "2"));
        Future f3 = es.submit(() -> searchEmulation(answer, 500, "3"));
        synchronized(answer) {
            while(! (f1.isDone() && f2.isDone() && f3.isDone()) && answer[0]==null) {
                answer.wait();
            }
            es.shutdownNow();
        }
        return answer[0];

    }

    static void searchEmulation(Object[] mailbox, int delay, Object answer) {
        //some work...
        if(Thread.currentThread().isInterrupted())
            return;
        //some more work...
        if(Thread.currentThread().isInterrupted())
            return;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            return;
        }
        //some more work...
        synchronized(mailbox) {
            if(mailbox[0]==null)
                mailbox[0] = answer;
            mailbox.notify(); //notify even if no result, to wake main thread to check.
        }

    }

}