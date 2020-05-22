public class SimpleThreadPool implements ISimpleThreadPool {

private LinkedBlockingQueue<ISimpleTask> queue = new LinkedBlockingQueue<>();

@Override
public void start() {
    (new Thread(new SimplePoolThread(queue))).start();
}