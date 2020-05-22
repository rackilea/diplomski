import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class DataProducer extends Thread {

    private final BlockingQueue<MyDataClass> queue ;

    public DataProducer(BlockingQueue<MyDataClass> queue) {
        this.queue = queue ;
        setDaemon(true);
    }

    @Override
    public void run()  {
        Random rng = new Random();
        try {
            while (true) {
                MyDataClass data = new MyDataClass(rng.nextInt(100));
                queue.put(data);
                Thread.sleep(rng.nextInt(1000) + 250);
            } 
        } catch (InterruptedException e) {
            // Ignore and allow thread to exit
        }
    }
}