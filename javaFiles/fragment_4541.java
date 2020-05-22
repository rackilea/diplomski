import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SomeQueueAbstraction {

    private final Queue<SomeObject> concurrentQueue = new ConcurrentLinkedQueue<>();
    private final AtomicInteger size = new AtomicInteger();

    public boolean add(Object request) {

        SomeObject object = convertIncomingRequest(request);   
        if (concurrentQueue.add(object)) {
            size.incrementAndGet();
            return true;
        }
        return false;
    }

    public SomeObject remove() {

        SomeObject object = concurrentQueue.poll();
        if (object != null) {
            size.decrementAndGet();
        }
        return object;
    }

    public int getSize() { return size.get(); }

    private SomeObject convertIncomingRequest(Object request) { 
        return new SomeObject(getSize()); 
    }

    class SomeObject {
        int id;
        SomeObject(int id) { this.id = id; }
    }
}