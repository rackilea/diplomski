import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

class CommunicationThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        return thread;
    }
}

public class ThreadEx implements Runnable {

    private byte[] pack;

    private final BlockingQueue writeBlockingQueue;

    public ThreadEx(BlockingQueue writeBlockingQueue, byte[] pack) {
        this.writeBlockingQueue = writeBlockingQueue;
        this.pack = pack;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            writeBlockingQueue.put(pack);
            // This line does not even produce output.
            System.out.println("In Thread " + Thread.currentThread().getName() + " got "
                + this.pack.length);
            writeBlockingQueue.take();
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        ExecutorService connectionThreadPool = Executors.newFixedThreadPool(15, new
                CommunicationThreadFactory());
        BlockingQueue<byte[]> blockingQueue = new ArrayBlockingQueue<>(10, true);

        byte[] packet = new byte[]{0x63, 0x41, 0x35, 0x19};
        for (int i = 0; i < 10; i++) {
            connectionThreadPool.execute(new ThreadEx(blockingQueue, packet));
        }
    }
}