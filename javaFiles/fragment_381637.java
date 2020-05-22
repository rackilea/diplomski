import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;

public class FlowSubscriber<T> implements Flow.Subscriber<T> {
    private final CountDownLatch latch = new CountDownLatch(1);
    private List<T> bodyItems = new ArrayList<>();

    public List<T> getBodyItems() {
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return bodyItems;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        //Retrieve all parts
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(T item) {
        this.bodyItems.add(item);
    }

    @Override
    public void onError(Throwable throwable) {
        this.latch.countDown();
    }

    @Override
    public void onComplete() {
        this.latch.countDown();
    }
}